# Mobile Extensions

This repository is a collection of reusable extension functions and components for cross-platform mobile development:

- 📱 **Kotlin (Android)**
- 🍏 **Swift (iOS)** *(coming soon)*
- 🐦 **Flutter** *(coming soon)*
- ⚛️ **React Native** *(coming soon)*

Each stack has its own subfolder. Currently, the project is active for Android with Kotlin.

## 📁 Structure

```
kotlin/         # Extensions and components for Android (Kotlin)
swift/          # Swift extensions (coming soon)
flutter/        # Flutter widgets and helpers (coming soon)
react-native/   # React Native components/utils (coming soon)
```

---

# 📱 Kotlin Extensions

A collection of useful Kotlin extension functions for Android development. These extensions simplify common tasks and improve code readability and maintainability.

## 📦 Available Extensions

### `ActivityExtensions.kt`
- `keyboardListener(isOpen: (Boolean) -> Unit)`
  - Monitors keyboard visibility in an Activity.

### `ContextExtensions.kt`
- `openUrl(url: String)`
  - Opens a URL in the default browser.
- `restartApp()`
  - Restarts the app by launching the main activity.

### `CpfUtils.kt`
- `maskCpf(cpf: String)`
  - Masks part of a CPF value (e.g., "12345678901" -> "12*.***.***01").
  - *Planned*: additional CPF validation and formatting functions.

### `SharedPreferences.kt`
- `save(key: String, value: String)`
  - Saves a string value in `SharedPreferences`.
- `get(key: String, default: String)`
  - Retrieves a string value, returning the default if not found.

### `StringExtensions.kt`
- `calculateAge()`
  - Calculates age based on a date string ("yyyy-MM-dd").
- `isValidEmail()`
  - Checks if the string is a valid email address.
- `isPasswordStrong()`
  - Checks if the string is a strong password (8+ characters, contains digits and uppercase letters).

### `TextViewExtensions.kt`
- `makeLinks(...)`
  - Applies clickable spans to portions of the text.
- `setTextColorHex(color: String)`
  - Sets the text color using a hex color value.

### `ViewExtensions.kt`
- `show()`, `invisible()`, `hide()`
  - Changes the visibility of a View.
- `coroutineViewState(...)`
  - Handles different View states (Success, Error, Loading, etc).

## 🚀 How to Use

Copy the desired `.kt` files from the `kotlin/` folder into your Android project. 

---

Contributions are welcome for any language!

