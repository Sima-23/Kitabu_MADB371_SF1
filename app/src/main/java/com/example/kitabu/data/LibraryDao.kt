package com.example.kitabu.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LibraryDao {

    @Query("SELECT * FROM books ORDER BY title")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query(
        """
        SELECT * FROM books
        WHERE title LIKE '%' || :query || '%'
        OR author LIKE '%' || :query || '%'
        ORDER BY title
        """
    )
    fun searchBooks(query: String): Flow<List<BookEntity>>

    @Query("SELECT * FROM books WHERE bookId = :id LIMIT 1")
    suspend fun getBookById(id: Int): BookEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<BookEntity>)

    @Insert
    suspend fun insertBooking(booking: BookingEntity)

    @Query(
        """
        SELECT * FROM bookings
        WHERE status = 'ACTIVE'
        ORDER BY returnDeadline
        """
    )
    fun getActiveBookings(): Flow<List<BookingEntity>>

    @Query(
        """
        SELECT * FROM bookings
        WHERE status = 'PENDING'
        ORDER BY bookingDate
        """
    )
    fun getPendingBookings(): Flow<List<BookingEntity>>

    @Query(
        """
        UPDATE books
        SET isAvailable = :available
        WHERE bookId = :bookId
        """
    )
    suspend fun updateAvailability(
        bookId: Int,
        available: Boolean
    )

    @Query(
        """
        UPDATE bookings
        SET returnDeadline = :deadline
        WHERE bookingId = :bookingId
        """
    )
    suspend fun renewBooking(
        bookingId: Int,
        deadline: Long
    )

    @Query(
        """
        UPDATE bookings
        SET status = 'RETURNED'
        WHERE bookingId = :bookingId
        """
    )
    suspend fun returnBook(
        bookingId: Int
    )

    @Query(
        """
        UPDATE bookings
        SET status = 'CANCELLED'
        WHERE bookingId = :bookingId
        AND status = 'PENDING'
        """
    )
    suspend fun cancelBooking(
        bookingId: Int
    )
}