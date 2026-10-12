\# Kitabu — Library Book Rental \& Reservation System



\## 1. Project Overview



Kitabu is a native Android application developed for the MADB372 Mobile Application Development B module. The application aims to help students browse library books, reserve available titles, and manage their book rentals.



The project uses Kotlin, Jetpack Compose, Room Database, Kotlin Coroutines, Kotlin Flow, and the Model-View-ViewModel (MVVM) architecture.



\## 2. Main Features



The application is designed to support the following features:



\- Browse a catalogue of library books.

\- Search for books by title or author.

\- View book details and availability.

\- Reserve books for a selected rental duration.

\- View active reservations and return deadlines.

\- Renew book rentals.

\- Return books and update their availability.

\- Cancel pending reservations.



\*\*Implementation status:\*\* Update this list to show which features are completed and tested in the current version.



\## 3. Technologies Used



\- \*\*Programming language:\*\* Kotlin

\- \*\*Development environment:\*\* Android Studio

\- \*\*User interface:\*\* Jetpack Compose with Material 3

\- \*\*Local database:\*\* Room Database (SQLite)

\- \*\*Architecture:\*\* Model-View-ViewModel (MVVM)

\- \*\*Asynchronous processing:\*\* Kotlin Coroutines

\- \*\*Reactive data:\*\* Kotlin Flow and StateFlow

\- \*\*Navigation:\*\* Jetpack Navigation Compose

\- \*\*Database code generation:\*\* KSP



\## 4. Project Architecture



The project is organised into packages to separate the user interface, application logic, and data management.



\- \*\*UI:\*\* Contains Compose screens, the application theme, and the ViewModel.

\- \*\*Data:\*\* Contains Room entities, the DAO, database configuration, and repository.

\- \*\*Navigation:\*\* Contains the navigation routes and screen navigation logic.



The ViewModel communicates with the repository, which accesses the database through the DAO. Room Flow and StateFlow are used to observe data changes and update the interface.



\## 5. Database Design



The application uses Room Database for local data storage.



\### BookEntity



Stores information about library books, including:



\- Book ID

\- Title

\- Author

\- Category

\- Description

\- Availability status



\### BookingEntity



Stores reservation information, including:



\- Booking ID

\- Book ID

\- User name

\- Booking date

\- Return deadline

\- Booking status



The booking entity references the book entity through a foreign key.



\## 6. Setup and Installation



\### Requirements



\- Android Studio

\- JDK 17 or a compatible configured Java 17 toolchain

\- Android SDK compatible with the project's Gradle configuration

\- Internet access for the initial Gradle dependency downloads



\### Steps



1\. Clone or download this repository.

2\. Open Android Studio.

3\. Select \*\*Open\*\* and choose the project folder.

4\. Allow Gradle to sync and download the required dependencies.

5\. Run the application using an Android emulator or compatible Android device.



The project uses Gradle to manage dependencies and build the application.



\## 7. Testing and CRUD Evidence



The following operations should be tested and documented with screenshots from the running application:



\- \*\*Create:\*\* Record a book reservation.

\- \*\*Read:\*\* Display books and reservation information.

\- \*\*Update:\*\* Renew a booking or update a book's availability after a return.

\- \*\*Delete/Cancel:\*\* Cancel a pending reservation according to the implemented cancellation logic.



Book catalog (screenshots/BookCatalog.jpeg)

Renew (screenshots/Renew.jpeg)

Return (screenshots/Return.jpeg)

\## 8. Project Structure



```text

Kitabu\_MADB372\_SF1/

├── app/

│   └── src/

│       └── main/

│           ├── java/com/example/kitabu/

│           │   ├── data/

│           │   ├── navigation/

│           │   └── ui/

│           └── res/

├── gradle/

├── .gitignore

├── build.gradle.kts

├── settings.gradle.kts

├── gradle.properties

└── README.md

```



The structure above is an overview. The exact files and folders may differ depending on the final project configuration.



\## 9. Limitations and Future Improvements



Document any incomplete features or known issues in the submitted version. Possible future improvements include improving the user interface, expanding the book catalogue, and adding further validation to reservation operations.



\## 10. Author and Academic Context



\*\*Project:\*\* Kitabu — Library Book Rental \& Reservation System  

\*\*Module:\*\* MADB372 — Mobile Application Development B  

\*\*Assignment:\*\* SF1  

\*\*Institution:\*\* STADIO Higher Education



\## 11. References



\- Android Developers — Jetpack Compose documentation: https://developer.android.com/jetpack/compose

\- Android Developers — Room persistence library: https://developer.android.com/training/data-storage/room

\- Android Developers — Navigation Compose: https://developer.android.com/develop/ui/compose/navigation

\- Kotlin documentation: https://kotlinlang.org/docs/home.html



References should reflect the resources consulted during development and follow the applicable STADIO referencing requirements.

