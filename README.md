# 🔐 LoginWithFirebaseAndLocal

<div align="center">

![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-1.6.0-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-Auth-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

**A production-ready Android authentication system with Firebase and Local login support**

Built with Clean Architecture • MVVM Pattern • Jetpack Compose

[Features](#-features) • [Architecture](#-architecture) • [Setup](#%EF%B8%8F-setup--installation) • [Screenshots](#-screenshots) • [Tech Stack](#%EF%B8%8F-tech-stack)

</div>

---

## 📱 Overview

**LoginWithFirebaseAndLocal** is a modern Android application demonstrating best practices in authentication, architecture, and UI design. It provides a **dual authentication system** supporting both **Firebase Authentication** for cloud-based login and **Local Authentication** for offline-first functionality.

### 🎯 Perfect For:
- 📚 **Learning** Clean Architecture and MVVM
- 💼 **Interview** preparation for Senior Android roles
- 🏢 **Production** projects requiring robust authentication
- 🎓 **Teaching** modern Android development

### 🌟 Why This Project?
- ✅ **Clean Architecture** - Scalable and maintainable codebase
- ✅ **Dual Auth System** - Firebase + Local (offline support)
- ✅ **Modern UI** - Jetpack Compose with Material 3
- ✅ **Production Ready** - Error handling, validation, security
- ✅ **Well Documented** - Clear code structure and comments

---

## ✨ Features

### 🔐 Authentication Features
- ✅ **Firebase Email/Password** - Cloud-based authentication
- ✅ **Local Authentication** - Offline login support
- ✅ **Auto-Login** - Remember user credentials
- ✅ **Session Management** - Secure token storage
- ✅ **Password Validation** - Real-time form validation
- ✅ **Error Handling** - User-friendly error messages
- ✅ **Loading States** - Visual feedback during auth operations

### 🎨 UI/UX Features
- ✅ **Modern Design** - Material 3 Design System
- ✅ **Dark Mode** - System theme support
- ✅ **Smooth Animations** - Transition animations
- ✅ **Responsive Layout** - Adapts to different screen sizes
- ✅ **Form Validation** - Real-time input validation
- ✅ **Toast Messages** - Success/Error notifications

### 🏗️ Technical Features
- ✅ **Clean Architecture** - Separation of concerns
- ✅ **MVVM Pattern** - Unidirectional data flow
- ✅ **Dependency Injection** - Dagger Hilt
- ✅ **State Management** - StateFlow + Compose State
- ✅ **Navigation** - Jetpack Navigation Compose
- ✅ **Data Persistence** - DataStore & Room Database
- ✅ **Coroutines** - Asynchronous operations
- ✅ **Testing Ready** - Unit test structure

---

## 🏛️ Architecture

This project follows **Clean Architecture** principles with clear separation between layers:

```
┌──────────────────────────────────────────────────────────┐
│                  Presentation Layer                       │
│  ┌────────────┐  ┌────────────┐  ┌────────────┐        │
│  │  Compose   │  │ ViewModel  │  │ Navigation │        │
│  │   Screens  │→ │  + State   │→ │   Graph    │        │
│  └────────────┘  └────────────┘  └────────────┘        │
└──────────────────────────────────────────────────────────┘
                         ↓ ↑
┌──────────────────────────────────────────────────────────┐
│                    Domain Layer                           │
│  ┌────────────┐  ┌────────────┐  ┌────────────┐        │
│  │ Use Cases  │  │   Models   │  │ Repository │        │
│  │ (Business) │  │  (Entity)  │  │ Interfaces │        │
│  └────────────┘  └────────────┘  └────────────┘        │
└──────────────────────────────────────────────────────────┘
                         ↓ ↑
┌──────────────────────────────────────────────────────────┐
│                     Data Layer                            │
│  ┌────────────┐  ┌────────────┐  ┌────────────┐        │
│  │  Firebase  │  │   Local    │  │   Mapper   │        │
│  │    Auth    │  │ DataStore  │  │ DTO↔Domain │        │
│  └────────────┘  └────────────┘  └────────────┘        │
└──────────────────────────────────────────────────────────┘
```

### 📊 Data Flow

```
User Interaction (Login Button)
         ↓
LoginScreen (Compose UI)
         ↓
LoginViewModel.login()
         ↓
LoginUseCase.execute()
         ↓
AuthRepository.loginWithFirebase() / loginLocally()
         ↓
FirebaseAuthSource / LocalAuthSource
         ↓
Result<User>
         ↓
StateFlow Update
         ↓
UI Recomposition
         ↓
Navigate to Home Screen
```

---

## 📂 Project Structure

```
com.example.loginapp/
│
├── 📁 presentation/                    # UI Layer
│   ├── 📁 navigation/                  # Navigation
│   │   ├── NavGraph.kt                 # Navigation routes
│   │   └── Screen.kt                   # Screen sealed class
│   │
│   ├── 📁 screen/                      # Compose Screens
│   │   ├── 📁 login/
│   │   │   ├── LoginScreen.kt          # Login UI
│   │   │   ├── LoginViewModel.kt       # Login logic
│   │   │   └── LoginUiState.kt         # UI state
│   │   │
│   │   ├── 📁 signup/
│   │   │   ├── SignUpScreen.kt
│   │   │   ├── SignUpViewModel.kt
│   │   │   └── SignUpUiState.kt
│   │   │
│   │   └── 📁 home/
│   │       ├── HomeScreen.kt
│   │       └── HomeViewModel.kt
│   │
│   ├── 📁 components/                  # Reusable UI
│   │   ├── CustomTextField.kt
│   │   ├── CustomButton.kt
│   │   ├── LoadingDialog.kt
│   │   └── ErrorText.kt
│   │
│   └── 📁 theme/                       # UI Theme
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
│
├── 📁 domain/                          # Business Logic
│   ├── 📁 model/                       # Domain Models
│   │   ├── User.kt
│   │   └── AuthResult.kt
│   │
│   ├── 📁 repository/                  # Interfaces
│   │   └── AuthRepository.kt
│   │
│   └── 📁 usecase/                     # Use Cases
│       ├── LoginUseCase.kt
│       ├── SignUpUseCase.kt
│       ├── LogoutUseCase.kt
│       └── GetCurrentUserUseCase.kt
│
├── 📁 data/                            # Data Layer
│   ├── 📁 repository/                  # Implementation
│   │   └── AuthRepositoryImpl.kt
│   │
│   ├── 📁 remote/                      # Firebase
│   │   └── FirebaseAuthSource.kt
│   │
│   ├── 📁 local/                       # Local Storage
│   │   ├── 📁 datastore/
│   │   │   └── UserPreferences.kt
│   │   │
│   │   └── 📁 room/
│   │       ├── UserDao.kt
│   │       ├── UserEntity.kt
│   │       └── AppDatabase.kt
│   │
│   ├── 📁 model/                       # Data Models
│   │   └── UserDto.kt
│   │
│   └── 📁 mapper/                      # Mappers
│       └── UserMapper.kt
│
├── 📁 di/                              # Dependency Injection
│   ├── AppModule.kt
│   ├── DatabaseModule.kt
│   └── RepositoryModule.kt
│
├── 📁 utils/                           # Utilities
│   ├── Constants.kt
│   ├── Extensions.kt
│   ├── Validator.kt
│   └── Resource.kt
│
└── MainActivity.kt                     # Entry Point
```

---

## 🛠️ Tech Stack

### 🎨 UI/UX
| Technology | Purpose |
|-----------|---------|
| **Jetpack Compose** | Modern declarative UI |
| **Material 3** | Design system |
| **Compose Navigation** | Screen navigation |
| **Accompanist** | Compose utilities |

### 🏗️ Architecture & Patterns
| Technology | Purpose |
|-----------|---------|
| **Clean Architecture** | Separation of concerns |
| **MVVM** | Presentation pattern |
| **Repository Pattern** | Data abstraction |
| **Use Cases** | Business logic |

### ⚙️ Core Libraries
| Technology | Purpose |
|-----------|---------|
| **Kotlin** | Programming language |
| **Coroutines** | Async operations |
| **Flow** | Reactive streams |
| **Dagger Hilt** | Dependency injection |

### 🔐 Authentication & Storage
| Technology | Purpose |
|-----------|---------|
| **Firebase Auth** | Cloud authentication |
| **DataStore** | Key-value storage |
| **Room** | Local database |
| **Encrypted SharedPreferences** | Secure storage |

### 🧪 Testing
| Technology | Purpose |
|-----------|---------|
| **JUnit** | Unit testing |
| **Mockk** | Mocking framework |
| **Turbine** | Flow testing |
| **Compose UI Test** | UI testing |

---

## 📸 Screenshots

<div align="center">

### Light Mode
| Login Screen | Sign Up Screen | Home Screen |
|:---:|:---:|:---:|
| ![Login](docs/screenshots/login_light.png) | ![SignUp](docs/screenshots/signup_light.png) | ![Home](docs/screenshots/home_light.png) |

### Dark Mode
| Login Screen | Sign Up Screen | Home Screen |
|:---:|:---:|:---:|
| ![Login](docs/screenshots/login_dark.png) | ![SignUp](docs/screenshots/signup_dark.png) | ![Home](docs/screenshots/home_dark.png) |

### Features Demo
| Validation | Loading State | Error Handling |
|:---:|:---:|:---:|
| ![Validation](docs/screenshots/validation.png) | ![Loading](docs/screenshots/loading.png) | ![Error](docs/screenshots/error.png) |

</div>

---

## ⚙️ Setup & Installation

### Prerequisites
- ✅ Android Studio Hedgehog (2023.1.1) or newer
- ✅ JDK 17 or higher
- ✅ Android SDK 34
- ✅ Gradle 8.2+
- ✅ Firebase Account

### 1️⃣ Clone Repository

```bash
git clone https://github.com/prasantpradhan/LoginWithFirebaseAndLocal.git
cd LoginWithFirebaseAndLocal
```

### 2️⃣ Firebase Setup

#### Create Firebase Project
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click **"Add Project"**
3. Enter project name: `LoginWithFirebaseAndLocal`
4. Follow setup wizard

#### Enable Authentication
1. Navigate to **Authentication** → **Sign-in method**
2. Enable **Email/Password** authentication
3. Click **Save**

#### Add Android App
1. Click **Android icon** to add Android app
2. Enter package name: `com.example.loginapp`
3. Download `google-services.json`
4. Place it in `app/` folder

#### Get SHA-1 (Optional - for advanced features)
```bash
# Debug SHA-1
keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android

# Release SHA-1 (use your keystore)
keytool -list -v -keystore /path/to/your/keystore.jks -alias your_alias
```

Add SHA-1 to Firebase:
1. Go to **Project Settings** → **Your Apps**
2. Click **Add fingerprint**
3. Paste SHA-1

### 3️⃣ Open in Android Studio

```
File → Open → Select project folder
```

### 4️⃣ Sync Gradle

```
File → Sync Project with Gradle Files
```

Or click the **Sync Now** banner that appears

### 5️⃣ Build Configuration

Update `local.properties` (optional):
```properties
sdk.dir=/path/to/Android/sdk
```

### 6️⃣ Run the App

```
Run → Run 'app'
```

Or press `Shift + F10`

---

## 🔑 Configuration

### Firebase Configuration
```kotlin
// app/build.gradle.kts
plugins {
    id("com.google.gms.google-services")
}

dependencies {
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
}
```

### Constants Configuration
```kotlin
// utils/Constants.kt
object Constants {
    const val DATABASE_NAME = "login_app_db"
    const val DATASTORE_NAME = "user_prefs"
    const val MIN_PASSWORD_LENGTH = 6
    const val SESSION_TIMEOUT = 30 * 60 * 1000L // 30 minutes
}
```

---

## 🎯 Usage Examples

### Login with Firebase
```kotlin
// In your Composable
val viewModel: LoginViewModel = hiltViewModel()
val uiState by viewModel.uiState.collectAsStateWithLifecycle()

Button(
    onClick = {
        viewModel.loginWithFirebase(
            email = "user@example.com",
            password = "password123"
        )
    }
) {
    Text("Login")
}

// Handle state
when {
    uiState.isLoading -> CircularProgressIndicator()
    uiState.error != null -> Text("Error: ${uiState.error}")
    uiState.isSuccess -> LaunchedEffect(Unit) {
        navigateToHome()
    }
}
```

### Login Locally
```kotlin
viewModel.loginLocally(
    username = "localuser",
    password = "localpass123"
)
```

### Sign Up
```kotlin
viewModel.signUp(
    email = "newuser@example.com",
    password = "securepass123",
    name = "John Doe"
)
```

---

## 🧪 Testing

### Run Unit Tests
```bash
./gradlew test
```

### Run UI Tests
```bash
./gradlew connectedAndroidTest
```

### Test Coverage
```bash
./gradlew jacocoTestReport
```

### Example Test Cases
```kotlin
class LoginViewModelTest {
    @Test
    fun `login with valid credentials returns success`() = runTest {
        // Given
        val email = "test@example.com"
        val password = "password123"
        
        // When
        viewModel.loginWithFirebase(email, password)
        
        // Then
        assertTrue(viewModel.uiState.value.isSuccess)
    }
    
    @Test
    fun `login with invalid email shows error`() = runTest {
        // Given
        val email = "invalid-email"
        val password = "password123"
        
        // When
        viewModel.loginWithFirebase(email, password)
        
        // Then
        assertNotNull(viewModel.uiState.value.error)
    }
}
```

---

## 🚀 Key Features Explained

### 1. Dual Authentication System

#### Firebase Authentication
```kotlin
suspend fun loginWithFirebase(email: String, password: String): Result<User> {
    return try {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        val user = result.user?.let { mapToUser(it) }
        Result.success(user!!)
    } catch (e: Exception) {
        Result.failure(e)
    }
}
```

#### Local Authentication
```kotlin
suspend fun loginLocally(username: String, password: String): Result<User> {
    return try {
        val user = userDao.getUserByUsername(username)
        if (user != null && user.password == hashPassword(password)) {
            Result.success(user.toDomain())
        } else {
            Result.failure(Exception("Invalid credentials"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}
```

### 2. State Management
```kotlin
data class LoginUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null,
    val user: User? = null
)

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    
    fun loginWithFirebase(email: String, password: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            
            loginUseCase(email, password).fold(
                onSuccess = { user ->
                    _uiState.update { it.copy(
                        isLoading = false,
                        isSuccess = true,
                        user = user
                    )}
                },
                onFailure = { error ->
                    _uiState.update { it.copy(
                        isLoading = false,
                        error = error.message
                    )}
                }
            )
        }
    }
}
```

### 3. Form Validation
```kotlin
object Validator {
    fun validateEmail(email: String): ValidationResult {
        return when {
            email.isBlank() -> ValidationResult.Error("Email cannot be empty")
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 
                ValidationResult.Error("Invalid email format")
            else -> ValidationResult.Success
        }
    }
    
    fun validatePassword(password: String): ValidationResult {
        return when {
            password.isBlank() -> ValidationResult.Error("Password cannot be empty")
            password.length < 6 -> 
                ValidationResult.Error("Password must be at least 6 characters")
            !password.any { it.isDigit() } -> 
                ValidationResult.Error("Password must contain at least one digit")
            !password.any { it.isUpperCase() } -> 
                ValidationResult.Error("Password must contain at least one uppercase letter")
            else -> ValidationResult.Success
        }
    }
}
```

---

## 📌 Roadmap & Future Enhancements

### 🔜 Coming Soon
- [ ] 🔐 **Biometric Authentication** (Fingerprint/Face ID)
- [ ] 🌐 **Google Sign-In**
- [ ] 📱 **Phone Authentication** (OTP)
- [ ] 🔗 **Social Login** (Facebook, Twitter)
- [ ] 📧 **Email Verification**
- [ ] 🔄 **Password Reset** flow
- [ ] 👤 **User Profile** management

### 🎯 Advanced Features
- [ ] 📶 **Offline-First** architecture
- [ ] 🔔 **Push Notifications**
- [ ] 🌍 **Multi-language** support
- [ ] 🎨 **Custom Themes**
- [ ] 📊 **Analytics** integration
- [ ] 🔒 **2FA** (Two-Factor Authentication)
- [ ] 🎵 **Voice Login**

### 🏗️ Architecture Improvements
- [ ] 🧩 **Multi-Module** structure
- [ ] 🎯 **Feature-based** packaging
- [ ] 🧪 **100% Test Coverage**
- [ ] 📝 **KDoc Documentation**
- [ ] 🎭 **UI Testing**
- [ ] 🔍 **Static Analysis** (Detekt)

---

## 🤝 Contributing

Contributions make the open-source community an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**!

### How to Contribute

1. **Fork** the Project
2. **Create** your Feature Branch
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. **Commit** your Changes
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. **Push** to the Branch
   ```bash
   git push origin feature/AmazingFeature
   ```
5. **Open** a Pull Request

### Contribution Guidelines

- Follow Kotlin coding conventions
- Write meaningful commit messages
- Add tests for new features
- Update documentation
- Keep PRs focused and small

---

## 📄 License

```
MIT License

Copyright (c) 2024 Prasant Kumar Pradhan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

---

## 👨‍💻 Author

<div align="center">

### **Prasant Kumar Pradhan**

Senior Android Developer | 8+ Years Experience

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/prasantpradhan)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/prasantpradhan)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:prasant.pradhan@example.com)

### 🎯 Expertise

```kotlin
val expertise = mapOf(
    "Languages" to listOf("Kotlin", "Java"),
    "UI" to listOf("Jetpack Compose", "XML Layouts"),
    "Architecture" to listOf("MVVM", "MVI", "Clean Architecture"),
    "DI" to listOf("Dagger Hilt", "Koin"),
    "Database" to listOf("Room", "SQLite", "Firebase"),
    "Networking" to listOf("Retrofit", "Ktor", "OkHttp"),
    "Async" to listOf("Coroutines", "Flow", "RxJava"),
    "Firebase" to listOf("Auth", "Firestore", "FCM", "Analytics"),
    "Payment" to listOf("Razorpay", "Stripe", "PayPal"),
    "Testing" to listOf("JUnit", "Mockk", "Espresso")
)
```

</div>

---

## 📚 Resources & Documentation

### 📖 Documentation
- [Setup Guide](docs/SETUP.md)
- [Architecture Details](docs/ARCHITECTURE.md)
- [API Documentation](docs/API.md)
- [Testing Guide](docs/TESTING.md)

### 🎓 Learning Resources
- [Android Developer Guide](https://developer.android.com/)
- [Jetpack Compose Pathway](https://developer.android.com/courses/pathways/compose)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

### 📺 Video Tutorials
- [Building with Jetpack Compose](https://www.youtube.com/playlist?list=PLWz5rJ2EKKc94tpHND8pW8Qt8ZfT4CPhT)
- [Firebase Authentication](https://www.youtube.com/watch?v=8I5bWJsNGY8)

---

## 🌟 Acknowledgments

Special thanks to:
- **Android Community** for amazing libraries
- **Firebase Team** for authentication services
- **Jetpack Compose Team** for modern UI toolkit
- **Open Source Contributors**

---

## ⭐ Support

If this project helped you, please consider:

- ⭐ **Starring** the repository
- 🍴 **Forking** for your own projects
- 📢 **Sharing** with others
- 🐛 **Reporting** bugs
- 💡 **Suggesting** new features

---

<div align="center">

### 💝 Made with Love by Prasant Kumar Pradhan

**Happy Coding! 🚀**

</div>
