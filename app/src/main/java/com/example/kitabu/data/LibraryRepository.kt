package com.example.kitabu.data

import com.example.kitabu.data.BookingEntity
import kotlin.Boolean
import kotlin.Int

class LibraryRepository(
    private val dao: LibraryDao
) {

    val books = dao.getAllBooks()

    val activeBookings = dao.getActiveBookings()

    val pendingBookings = dao.getPendingBookings()

    fun searchBooks(query: String) =
        dao.searchBooks(query)

    suspend fun getBook(id: Int): BookEntity? {
        return dao.getBookById(id)
    }

    suspend fun insertBooks(books: List<BookEntity>) {
        dao.insertBooks(books)
    }

    suspend fun reserveBook(
        book: BookEntity,
        userName: String,
        days: Int
    ) {

        val currentTime = System.currentTimeMillis()

        val deadline =
            currentTime + (days * 24L * 60L * 60L * 1000L)

        val booking = BookingEntity(
            bookId = book.bookId,
            userName = userName,
            bookingDate = currentTime,
            returnDeadline = deadline,
            status = "ACTIVE"
        )

        dao.insertBooking(booking)

        dao.updateAvailability(
            bookId = book.bookId,
            available = false
        )
    }

    suspend fun renewBooking(
        booking: BookingEntity
    ) {

        val newDeadline =
            booking.returnDeadline +
                    (14L * 24L * 60L * 60L * 1000L)

        dao.renewBooking(
            booking.bookingId,
            newDeadline
        )
    }

    suspend fun returnBook(
        booking: BookingEntity
    ) {

        dao.returnBook(
            booking.bookingId
        )

        dao.updateAvailability(
            booking.bookId,
            true
        )
    }

    suspend fun cancelBooking(
        booking: BookingEntity
    ) {

        dao.cancelBooking(
            booking.bookingId
        )
    }
}