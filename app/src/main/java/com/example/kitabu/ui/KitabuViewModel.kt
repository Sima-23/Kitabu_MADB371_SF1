package com.example.kitabu.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitabu.data.BookEntity
import com.example.kitabu.data.BookingEntity
import com.example.kitabu.data.KitabuDatabase
import com.example.kitabu.data.LibraryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class KitabuViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val database =
        KitabuDatabase.getDatabase(application)

    private val repository =
        LibraryRepository(database.libraryDao())

    private val searchQuery =
        MutableStateFlow("")

    val books: StateFlow<List<BookEntity>> =
        searchQuery
            .flatMapLatest { query ->

                if (query.isBlank()) {
                    repository.books
                } else {
                    repository.searchBooks(query)
                }

            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )

    val activeBookings =
        repository.activeBookings.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    val pendingBookings =
        repository.pendingBookings.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    init {

        viewModelScope.launch {

            if (repository.getBook(1) == null) {

                repository.insertBooks(
                    sampleBooks
                )
            }
        }
    }

    fun searchBooks(
        text: String
    ) {
        searchQuery.value = text
    }
    suspend fun getBook(id: Int): BookEntity? {
        return repository.getBook(id)
    }

    fun reserveBook(
        book: BookEntity,
        days: Int,
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch {
            repository.reserveBook(book, "Student", days)
            onSuccess()
        }
    }

    fun renewBooking(
        booking: BookingEntity
    ) {

        viewModelScope.launch {

            repository.renewBooking(
                booking
            )
        }
    }

    fun returnBook(
        booking: BookingEntity
    ) {

        viewModelScope.launch {

            repository.returnBook(
                booking
            )
        }
    }

    fun cancelBooking(
        booking: BookingEntity
    ) {

        viewModelScope.launch {

            repository.cancelBooking(
                booking
            )
        }
    }

    companion object {

        val sampleBooks =
            listOf(

                BookEntity(
                    title = "Clean Code",
                    author = "Robert C. Martin",
                    category = "Computer Science",
                    description =
                        "A practical guide to writing clean and maintainable software."
                ),

                BookEntity(
                    title = "Data Structures and Algorithms",
                    author = "Thomas H. Cormen",
                    category = "Computer Science",
                    description =
                        "An introduction to important data structures and algorithms."
                ),

                BookEntity(
                    title = "Introduction to Psychology",
                    author = "David G. Myers",
                    category = "Psychology",
                    description =
                        "An introduction to psychology and human behaviour."
                ),

                BookEntity(
                    title = "Business Management",
                    author = "Koontz and O'Donnell",
                    category = "Business",
                    description =
                        "Fundamental principles of business and management."
                ),

                BookEntity(
                    title = "Database Systems",
                    author = "Thomas Connolly",
                    category = "Information Technology",
                    description =
                        "Concepts and techniques used to design database systems."
                ),

                BookEntity(
                    title = "Android Development",
                    author = "Bill Phillips",
                    category = "Mobile Development",
                    description =
                        "Learn Android application development using modern tools."
                )
            )
    }
}