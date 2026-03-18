# DarkSoulsStoryBuilder

An Android application that generates epic, dark fantasy stories inspired by the *Dark Souls* and *Elden Ring* universe. Enter details about your hero and let the app craft a brutal, immersive narrative in the style of FromSoftware games.

## Features

- Input your hero's name, origin, weapon type, and primary enemy
- Generates a personalized Dark Souls / Elden Ring-style story prompt
- Dark medieval UI theme

## Requirements

- Android API 24 (Android 7.0 Nougat) or higher
- Internet permission (for future AI story generation)

## Tech Stack

- **Language:** Java
- **UI:** Material Design 3, ConstraintLayout
- **Networking:** OkHttp3
- **Build System:** Gradle (Kotlin DSL)

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/LilStick/androidElden.git
   ```
2. Open the project in **Android Studio**.
3. Build and run the app on an emulator or physical device (API 24+).

## Project Structure

```
app/src/main/
├── java/com/example/darksoulsstorybuilder/
│   └── MainActivity.java   # Hero input form and story prompt builder
└── res/
    ├── layout/activity_main.xml
    └── values/             # Colors, strings, themes
```

## License

This project is for personal/educational use.
