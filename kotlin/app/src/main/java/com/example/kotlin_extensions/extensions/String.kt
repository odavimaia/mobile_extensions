package com.example.kotlin_extensions.extensions


import android.util.Patterns
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*



/**
 * Calculates the age based on a birthdate string in the format "yyyy-MM-dd".
 * This function will parse the string into a `LocalDate`, calculate the difference between
 * the birthdate and the current date, and return the age in years.
 *
 * If the string format is invalid or any other error occurs, the function will return -1.
 *
 * @return The calculated age in years, or -1 if there was an error parsing the date.
 */
fun String.calculateAge(): Int {
    return try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault()) // Define date format
        val birthDate = LocalDate.parse(this, formatter) // Parse the birthdate string
        val today = LocalDate.now() // Get today's date
        Period.between(birthDate, today).years // Calculate the difference in years
    } catch (e: Exception) {
        -1 // Return -1 in case of an error (could also throw the error if needed)
    }
}

/**
 * Validates if the string is a valid email address based on Android's built-in regex pattern.
 *
 * This function checks if the string matches the general pattern for valid email addresses,
 * such as "user@example.com".
 *
 * @return `true` if the string is a valid email, `false` otherwise.
 */
fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches() // Validate email using regex pattern
}

/**
 * Checks if the string is a strong password.
 * A strong password is defined as one that:
 * - Contains at least one uppercase letter.
 * - Contains at least one digit.
 * - Is at least 8 characters long.
 *
 * @return `true` if the password is strong, `false` otherwise.
 */
fun String.isPasswordStrong(): Boolean {
    val hasUppercase = any { it.isUpperCase() } // Check if string contains an uppercase letter
    val hasDigit = any { it.isDigit() } // Check if string contains a digit
    val isLongEnough = length >= 8 // Check if string length is at least 8 characters
    return hasUppercase && hasDigit && isLongEnough // Return true if all conditions are met
}