package com.example.kotlin_extensions.extensions

import android.content.Context
import android.content.SharedPreferences

/**
 * Retrieves the SharedPreferences instance for the app with the name "default_prefs".
 *
 * @return The SharedPreferences instance used to store and retrieve app data.
 */
private fun Context.getSharedPrefs(): SharedPreferences =
    getSharedPreferences("default_prefs", Context.MODE_PRIVATE)

/**
 * Saves a string value in SharedPreferences with the specified key.
 *
 * @param key The key under which the value will be saved.
 * @param value The string value to be saved.
 */
fun Context.saveToPrefs(key: String, value: String) {
    getSharedPrefs().edit().putString(key, value).apply()
}

/**
 * Retrieves a string value from SharedPreferences for the specified key.
 * If the key does not exist, it returns the provided default value.
 *
 * @param key The key to retrieve the value for.
 * @param default The default value to return if the key does not exist.
 * @return The string value associated with the key, or the default value if the key is not found.
 */
fun Context.getFromPrefs(key: String, default: String = ""): String {
    return getSharedPrefs().getString(key, default) ?: default
}