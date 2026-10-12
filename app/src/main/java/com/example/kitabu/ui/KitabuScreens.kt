package com.example.kitabu.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.kitabu.R
import com.example.kitabu.data.BookEntity
import com.example.kitabu.data.BookingEntity

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

@Composable
fun WelcomeScreen(
    onGetStarted: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F2))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "📚",
            fontSize = 80.sp
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Welcome to Kitabu",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Your digital library for finding, reserving and managing books.",
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(
            onClick = onGetStarted,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Get Started")
        }
    }
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        // KITABU LOGO

        Icon(
            imageVector = Icons.Default.MenuBook,

            contentDescription = "Kitabu Logo",

            tint = Color(0xFF2EAD59),

            modifier = Modifier.size(70.dp)
        )

        Text(
            text = "Kitabu",

            color = Color(0xFF08783C),

            fontSize = 26.sp,

            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // LOGIN TITLE

        Text(
            text = "Login",

            fontSize = 24.sp,

            fontWeight = FontWeight.Bold,

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Text(
            text = "Welcome back! Please login to your account",

            fontSize = 12.sp,

            color = Color.Gray,

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // EMAIL

        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
            },

            placeholder = {
                Text("Email")
            },

            modifier = Modifier.fillMaxWidth(),

            singleLine = true,

            shape = RoundedCornerShape(5.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // PASSWORD

        OutlinedTextField(
            value = password,

            onValueChange = {
                password = it
            },

            placeholder = {
                Text("Password")
            },

            visualTransformation =
                PasswordVisualTransformation(),

            modifier = Modifier.fillMaxWidth(),

            singleLine = true,

            shape = RoundedCornerShape(5.dp)
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // LOGIN BUTTON

        Button(
            onClick = onLogin,

            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),

            shape = RoundedCornerShape(5.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2EAD59)
            )
        ) {

            Text("Login")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        // FORGOT PASSWORD

        TextButton(
            onClick = {}
        ) {

            Text(
                text = "Forgot Password?",

                color = Color.Gray,

                fontSize = 12.sp
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically
        ) {

            androidx.compose.material3.HorizontalDivider(
                modifier = Modifier.weight(1f),

                color = Color.LightGray
            )

            Text(
                text = "  OR  ",

                color = Color.Gray,

                fontSize = 11.sp
            )

            androidx.compose.material3.HorizontalDivider(
                modifier = Modifier.weight(1f),

                color = Color.LightGray
            )
        }

        Spacer(
            modifier = Modifier.height(14.dp)
        )

        // CREATE ACCOUNT

        OutlinedButton(
            onClick = {},

            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),

            shape = RoundedCornerShape(5.dp)
        ) {

            Text(
                text = "Create an Account",

                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun HomeScreen(
    onCatalog: () -> Unit,
    onReservations: () -> Unit,
    onProfile: () -> Unit
) {
    Scaffold(
        bottomBar = {
            KitabuBottomNavigation(
                currentScreen = "home",
                onHome = {},
                onSearch = onCatalog,
                onReservations = onReservations,
                onProfile = onProfile
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF8FAF8))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2EAD59))
                    .padding(
                        start = 20.dp,
                        end = 16.dp,
                        top = 14.dp,
                        bottom = 14.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Kitabu",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Connect • Reserve • Learn",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 11.sp
                    )
                }

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = onProfile
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {

                // SEARCH BAR
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text(
                            text = "Search for books, authors, or subjects"
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2EAD59),
                        unfocusedBorderColor = Color(0xFFD9DED9)
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(155.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF08783C)
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Explore",
                                color = Color.White,
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Great Books",
                                color = Color.White,
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Find your next read,\nreserve or rent today!",
                                color = Color.White.copy(alpha = 0.9f),
                                fontSize = 12.sp
                            )
                        }


                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "📚",
                                fontSize = 55.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    HomeActionCard(
                        icon = Icons.Default.MenuBook,
                        title = "Browse Books",
                        modifier = Modifier.weight(1f),
                        onClick = onCatalog
                    )

                    HomeActionCard(
                        icon = Icons.Default.CalendarMonth,
                        title = "My Reservations",
                        modifier = Modifier.weight(1f),
                        onClick = onReservations
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    HomeActionCard(
                        icon = Icons.Default.Book,
                        title = "My Rentals",
                        modifier = Modifier.weight(1f),
                        onClick = onReservations
                    )

                    HomeActionCard(
                        icon = Icons.Default.Person,
                        title = "Profile",
                        modifier = Modifier.weight(1f),
                        onClick = onProfile
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun HomeActionCard(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(115.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF08783C),
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF26332B)
            )
        }
    }
}

@Composable
fun KitabuBottomNavigation(
    currentScreen: String,
    onHome: () -> Unit,
    onSearch: () -> Unit,
    onReservations: () -> Unit,
    onProfile: () -> Unit
) {
    NavigationBar(
        containerColor = Color.White
    ) {

        NavigationBarItem(
            selected = currentScreen == "home",
            onClick = onHome,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = currentScreen == "search",
            onClick = onSearch,
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            label = {
                Text("Search")
            }
        )

        NavigationBarItem(
            selected = currentScreen == "reservations",
            onClick = onReservations,
            icon = {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "Reservations"
                )
            },
            label = {
                Text("Reservations")
            }
        )

        NavigationBarItem(
            selected = currentScreen == "profile",
            onClick = onProfile,
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text("Profile")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    onViewDetails: (Int) -> Unit,
    onReservationSuccess: (Int) -> Unit,
    viewModel: KitabuViewModel = viewModel()
) {
    val books by viewModel.books.collectAsState()

    var searchText by remember {
        mutableStateOf("")
    }

    var selectedCategory by remember {
        mutableStateOf("All")
    }

    var selectedBook by remember {
        mutableStateOf<BookEntity?>(null)
    }

    var showDialog by remember {
        mutableStateOf(false)
    }

    val filteredBooks = when (selectedCategory) {
        "All" -> books

        "Science" -> books.filter {
            it.category.contains("Science", ignoreCase = true)
        }

        "Business" -> books.filter {
            it.category.contains("Business", ignoreCase = true)
        }

        "IT" -> books.filter {
            it.category.contains("Computer", ignoreCase = true) ||
                    it.category.contains("Information", ignoreCase = true) ||
                    it.category.contains("Mobile", ignoreCase = true)
        }

        else -> books
    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text(
                        text = "Book Catalog",
                        fontWeight = FontWeight.Bold
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2E7D32),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF7F9F7))
                .padding(16.dp)

        ) {

            // Search bar

            OutlinedTextField(

                value = searchText,

                onValueChange = {
                    searchText = it
                    viewModel.searchBooks(it)
                },

                modifier = Modifier
                    .fillMaxWidth(),

                placeholder = {
                    Text("Search by title or author")
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },

                singleLine = true,

                shape = RoundedCornerShape(14.dp),

                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF2E7D32),
                    unfocusedBorderColor = Color.LightGray
                )
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Category title

            Text(
                text = "Categories",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // Category buttons

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                CategoryChip(
                    text = "All",
                    selected = selectedCategory == "All",
                    onClick = {
                        selectedCategory = "All"
                    }
                )

                CategoryChip(
                    text = "IT",
                    selected = selectedCategory == "IT",
                    onClick = {
                        selectedCategory = "IT"
                    }
                )

                CategoryChip(
                    text = "Science",
                    selected = selectedCategory == "Science",
                    onClick = {
                        selectedCategory = "Science"
                    }
                )

                CategoryChip(
                    text = "Business",
                    selected = selectedCategory == "Business",
                    onClick = {
                        selectedCategory = "Business"
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = "Available Books",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    filteredBooks,
                    key = { it.bookId }
                ) { book ->
                    BookCard(
                        book = book,
                        onReserve = {
                            selectedBook = book
                            showDialog = true
                        },
                        onViewDetails = {
                            onViewDetails(book.bookId)
                        }
                    )
                }
            }
        }
    }

    if (showDialog && selectedBook != null) {
        ReservationDialog(
            book = selectedBook!!,
            onDismiss = {
                showDialog = false
            },
            onReserve = { days ->
                val reservedBookId = selectedBook!!.bookId

                viewModel.reserveBook(
                    book = selectedBook!!,
                    days = days,
                    onSuccess = {
                        showDialog = false
                        onReservationSuccess(reservedBookId)
                    }
                )
            }
        )
    }
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BookDetailsScreen(
        bookId: Int,
        onReservationSuccess: () -> Unit,
        viewModel: KitabuViewModel = viewModel()
    ) {
    var book by remember {
        mutableStateOf<BookEntity?>(null)
    }

    LaunchedEffect(bookId) {
        book = viewModel.getBook(bookId)
    }

    if (book == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color(0xFF2E7D32)
            )
        }

        return
    }

    val currentBook = book!!

    val imageRes = when (currentBook.title) {
        "Clean Code" -> R.drawable.clean_code
        "Data Structures and Algorithms" -> R.drawable.data_structures
        "Introduction to Psychology" -> R.drawable.psychology
        "Business Management" -> R.drawable.business_management
        "Database Systems" -> R.drawable.database_systems
        "Android Development" -> R.drawable.android_development
        else -> R.drawable.clean_code
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Book Details")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            // We will connect the back button next
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2EAD59),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {

            // Book cover
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = currentBook.title,
                    modifier = Modifier
                        .width(180.dp)
                        .height(240.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Book title
            Text(
                text = currentBook.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF222222)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Author
            Text(
                text = currentBook.author,
                fontSize = 15.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Category
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFFE8F5E9)
            ) {
                Text(
                    text = currentBook.category,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    ),
                    color = Color(0xFF2E7D32),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Availability
            Text(
                text = "Availability",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = if (currentBook.isAvailable) {
                    "● In stock"
                } else {
                    "● Reserved"
                },
                color = if (currentBook.isAvailable) {
                    Color(0xFF2E7D32)
                } else {
                    Color(0xFFC62828)
                },
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Reserve button
            Button(
                onClick = {
                    viewModel.reserveBook(
                        book = currentBook,
                        days = 14,
                        onSuccess = onReservationSuccess
                    )
                },
                enabled = currentBook.isAvailable,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reserve Book")
            }

            Spacer(modifier = Modifier.height(25.dp))

            // Description
            Text(
                text = "Description",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = currentBook.description,
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 21.sp
            )
        }
    }
}

    @Composable
    fun ReservationSuccessScreen(
        bookId: Int,
        onViewReservation: () -> Unit,
        viewModel: KitabuViewModel = viewModel()
    ) {

        var book by remember {
            mutableStateOf<BookEntity?>(null)
        }

        LaunchedEffect(bookId) {
            book = viewModel.getBook(bookId)
        }

        val currentBook = book

        if (currentBook == null) {

            Box(
                modifier = Modifier.fillMaxSize(),

                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator(
                    color = Color(0xFF2EAD59)
                )
            }

            return
        }

        val imageRes = when (currentBook.title) {

            "Clean Code" ->
                R.drawable.clean_code

            "Data Structures and Algorithms" ->
                R.drawable.data_structures

            "Introduction to Psychology" ->
                R.drawable.psychology

            "Business Management" ->
                R.drawable.business_management

            "Database Systems" ->
                R.drawable.database_systems

            "Android Development" ->
                R.drawable.android_development

            else ->
                R.drawable.clean_code
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally,

            verticalArrangement =
                Arrangement.Center
        ) {


            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        Color(0xFF22B957),
                        CircleShape
                    ),

                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Check,

                    contentDescription = "Success",

                    tint = Color.White,

                    modifier = Modifier.size(45.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            Text(
                text = "Reservation Successful!",

                fontSize = 19.sp,

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Your book has been reserved.\nYou will be notified once it is ready for collection.",

                textAlign = TextAlign.Center,

                color = Color.Gray,

                fontSize = 12.sp
            )

            Spacer(
                modifier = Modifier.height(25.dp)
            )


            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(8.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Image(
                        painter =
                            painterResource(
                                id = imageRes
                            ),

                        contentDescription =
                            currentBook.title,

                        modifier = Modifier
                            .width(55.dp)
                            .height(70.dp)
                            .clip(
                                RoundedCornerShape(5.dp)
                            ),

                        contentScale =
                            ContentScale.Crop
                    )

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column {

                        Text(
                            text = currentBook.title,

                            fontWeight =
                                FontWeight.Bold,

                            fontSize = 14.sp
                        )

                        Text(
                            text = currentBook.author,

                            fontSize = 11.sp,

                            color = Color.Gray
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "Reservation ID: #RSV-${bookId}-${System.currentTimeMillis().toString().takeLast(4)}",

                            fontSize = 9.sp,

                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )


            Button(
                onClick = onViewReservation,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),

                shape = RoundedCornerShape(6.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2EAD59)
                )
            ) {

                Text("View My Reservation")
            }
        }
    }

@Composable
fun CategoryChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = if (selected) {
            Color(0xFF2E7D32)
        } else {
            Color.White
        },
        border = BorderStroke(
            1.dp,
            if (selected) {
                Color(0xFF2E7D32)
            } else {
                Color.LightGray
            }
        )
    ) {

        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 9.dp
            ),
            color = if (selected) {
                Color.White
            } else {
                Color.DarkGray
            },
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BookCard(
    book: BookEntity,
    onReserve: () -> Unit,
    onViewDetails: () -> Unit
) {
    val imageRes = when (book.title) {
        "Clean Code" -> R.drawable.clean_code
        "Data Structures and Algorithms" -> R.drawable.data_structures
        "Introduction to Psychology" -> R.drawable.psychology
        "Business Management" -> R.drawable.business_management
        "Database Systems" -> R.drawable.database_systems
        "Android Development" -> R.drawable.android_development
        else -> R.drawable.clean_code
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Book image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = book.title,
                modifier = Modifier
                    .width(85.dp)
                    .height(115.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(14.dp))

            // Book information
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = book.title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF222222)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = book.author,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = book.category,
                    fontSize = 12.sp,
                    color = Color(0xFF2E7D32),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (book.isAvailable) {
                        Color(0xFFE8F5E9)
                    } else {
                        Color(0xFFFFEBEE)
                    }
                ) {
                    Text(
                        text = if (book.isAvailable) {
                            "Available"
                        } else {
                            "Unavailable"
                        },
                        modifier = Modifier.padding(
                            horizontal = 10.dp,
                            vertical = 5.dp
                        ),
                        fontSize = 12.sp,
                        color = if (book.isAvailable) {
                            Color(0xFF2E7D32)
                        } else {
                            Color(0xFFC62828)
                        },
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Reserve button
                Button(
                    onClick = onReserve,
                    enabled = book.isAvailable,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2E7D32)
                    )
                ) {
                    Text(
                        text = "Reserve",
                        fontSize = 12.sp
                    )
                }
            }

            // Arrow to view book details
            IconButton(
                onClick = onViewDetails,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "View book details",
                    tint = Color(0xFF555555)
                )
            }
        }
    }
}

@Composable
fun ReservationDialog(
    book: BookEntity,
    onDismiss: () -> Unit,
    onReserve: (Int) -> Unit
) {

    var selectedDays by remember {
        mutableStateOf(14)
    }

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {
            Text("Reserve Book")
        },

        text = {

            Column {

                Text(
                    text = book.title,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                Text(
                    "Choose rental duration:"
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Row {

                    FilterChip(
                        selected = selectedDays == 7,
                        onClick = {
                            selectedDays = 7
                        },
                        label = {
                            Text("7 days")
                        }
                    )

                    Spacer(
                        modifier = Modifier.size(8.dp)
                    )

                    FilterChip(
                        selected = selectedDays == 14,
                        onClick = {
                            selectedDays = 14
                        },
                        label = {
                            Text("14 days")
                        }
                    )

                    Spacer(
                        modifier = Modifier.size(8.dp)
                    )

                    FilterChip(
                        selected = selectedDays == 30,
                        onClick = {
                            selectedDays = 30
                        },
                        label = {
                            Text("30 days")
                        }
                    )
                }
            }
        },

        confirmButton = {

            Button(
                onClick = {
                    onReserve(selectedDays)
                }
            ) {

                Text("Reserve")
            }
        },

        dismissButton = {

            TextButton(
                onClick = onDismiss
            ) {

                Text("Cancel")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationsScreen(
    viewModel: KitabuViewModel = viewModel()
) {

    val bookings by
    viewModel.activeBookings.collectAsState()

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("My Reservations")
                }
            )
        }

    ) { padding ->

        if (bookings.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment =
                    Alignment.Center
            ) {

                Text(
                    text =
                        "You have no active reservations."
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(15.dp),
                verticalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                items(
                    bookings,
                    key = {
                        it.bookingId
                    }
                ) { booking ->

                    ReservationCard(
                        booking = booking,
                        onRenew = {
                            viewModel.renewBooking(
                                booking
                            )
                        },
                        onReturn = {
                            viewModel.returnBook(
                                booking
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ReservationCard(
    booking: BookingEntity,
    onRenew: () -> Unit,
    onReturn: () -> Unit
) {

    val dateFormat =
        SimpleDateFormat(
            "dd MMM yyyy",
            Locale.getDefault()
        )

    val deadline =
        dateFormat.format(
            Date(booking.returnDeadline)
        )

    val daysRemaining =
        TimeUnit.MILLISECONDS.toDays(
            booking.returnDeadline -
                    System.currentTimeMillis()
        ).coerceAtLeast(0)

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "Book ID: ${booking.bookId}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Reservation date: ${
                    dateFormat.format(
                        Date(booking.bookingDate)
                    )
                }"
            )

            Text(
                text = "Return deadline: $deadline"
            )

            Text(
                text = "Days remaining: $daysRemaining"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = onRenew,
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        Icons.Default.Refresh,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(4.dp)
                    )

                    Text("Renew")
                }

                Button(
                    onClick = onReturn,
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        Icons.Default.KeyboardReturn,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(4.dp)
                    )

                    Text("Return")
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Icon(
            Icons.Default.AccountCircle,
            contentDescription = "Profile",
            modifier = Modifier.size(100.dp)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Student",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "student@kitabu.com"
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Account",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                Text("Name: Student")

                Text("Email: student@kitabu.com")

                Text("Library Member")
            }
        }
    }
}