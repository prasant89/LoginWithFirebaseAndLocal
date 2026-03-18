📱 App Name

LoginWithFirebaseAndLocal

🚀 Overview

This project is an Android application built using MVVM Clean Architecture with Jetpack Compose.
It supports Firebase Authentication and Local Login, ensuring flexibility and scalability for real-world apps.

✨ Features

🔐 Firebase Authentication (Email/Password)

🧑‍💻 Local Authentication (Offline support)

🧭 Navigation using Navigation Compose

🎨 Modern UI with Jetpack Compose

⚡ State management using ViewModel & StateFlow

💾 Data persistence using DataStore / Room

🧪 Unit Testing support

🔒 Secure architecture (Clean Architecture principles)

🏗️ Architecture

This project follows MVVM + Clean Architecture:

presentation/
    ├── ui (Compose Screens)
    ├── viewmodel
domain/
    ├── usecase
    ├── repository (interface)
data/
    ├── repository (implementation)
    ├── local
    ├── remote
🛠️ Tech Stack

Kotlin

Jetpack Compose

MVVM Architecture

Hilt (Dependency Injection)

Retrofit (API calls)

Firebase Auth

DataStore / Room

Coroutines & Flow

📸 Screenshots

Add screenshots here

![Login Screen](screenshots/login.png)
![Home Screen](screenshots/home.png)
⚙️ Setup & Installation

Clone the repository

git clone https://github.com/your-username/LoginWithFirebaseAndLocal.git

Open in Android Studio

Add Firebase Configuration

Go to Firebase Console

Download google-services.json

Place it inside /app folder

Sync project

Run the app 🚀

🔑 Firebase Setup

Enable Email/Password Authentication

Add SHA-1 in Firebase Console (for advanced auth)

📂 Modules (Optional for Multi-Module Setup)

app

core

data

domain

presentation

🧪 Testing

Unit Tests for ViewModel

Repository layer testing

Run tests:

./gradlew test
📌 Future Enhancements

🔐 Biometric Authentication

🌐 Social Login (Google, Facebook)

📶 Offline-first architecture

🔔 Push Notifications

🎵 Audio/Voice login (experimental)

🤝 Contributing

Contributions are welcome!
Feel free to fork this repo and submit a pull request.

📄 License

This project is licensed under the MIT License.

👨‍💻 Author

Prasant Pradhan
Android Developer | Kotlin | Jetpack Compose | MVVM

⭐ Support

If you like this project, give it a ⭐ on GitHub!

If you want, I can also:

Customize this README specifically for your BMW app / Navigation app

Add badges (build, version, license)

Generate a GitHub repo description + bio + tags 🚀
