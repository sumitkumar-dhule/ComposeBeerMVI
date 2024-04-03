**Android Clean MVI Architecture Sample**

This repository contains a code sample demonstrating the implementation of Clean Model-View-Intent (MVI) architecture in an Android application. The architecture aims to promote separation of concerns, scalability, and maintainability by organizing code into distinct layers.

### Overview

The application demonstrates the following key components and technologies:

- Clean MVI Architecture: A variation of the Model-View-Intent pattern that emphasizes separation of concerns and unidirectional data flow.
- Kotlin Coroutines: Used for asynchronous and non-blocking programming.
- ViewModel: Android Architecture Component that provides a lifecycle-aware container to hold and manage UI-related data.
- Coil: Image loading library for Android.
- Retrofit: Type-safe HTTP client for Android and Java.
- Jetpack Compose: Modern UI toolkit for building native Android UIs.
- GSON Converter Factory: JSON serialization/deserialization library for converting Java Objects into JSON and back.
- Dagger Hilt: Dependency injection library for Android.
- MockK: Mocking library for Kotlin

### Project Structure

The project is structured into the following packages:

- `data`: Contains data-related classes such as repositories, data sources, and models.
- `domain`: Contains domain logic, including use cases and domain models.
- `presentation`: Contains UI-related classes such as ViewModels, states, and actions.
- `di`: Contains Dagger Hilt dependency injection setup.
- `ui`: Contains Jetpack Compose UI components and screens.
- `util`: Contains utility classes and extensions.

### Setup

To run the project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/sumitkumar-dhule/ComposeBeerMVI.git`
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

### Usage

Upon running the application, you will be presented with the main screen, which displays a list of items fetched from a remote API. You can interact with the UI to navigate between screens, view item details, and handle potential errors gracefully.

### Testing

The project includes unit tests using MockK for mocking dependencies. You can run these tests to ensure the correctness and reliability of the codebase.

### Additional Notes

- Ensure you have the necessary dependencies and SDK versions configured in your `build.gradle` files.
- Make sure to provide proper error handling and manage resources efficiently throughout the application.
- Follow consistent coding conventions and adhere to SOLID principles for better code maintainability.
- Regularly update dependencies to benefit from the latest features and security patches.

### Author

[Sumitkumar Dhule](https://github.com/sumitkumar-dhule)

### Contributions

Contributions are welcome! If you'd like to contribute to this project, feel free to submit a pull request or open an issue.

### Feedback

If you have any feedback or suggestions, please feel free to reach out via GitHub issues.

---

