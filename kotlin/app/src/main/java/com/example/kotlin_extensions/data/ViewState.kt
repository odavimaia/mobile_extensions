package com.example.kotlin_extensions.data

/**
 * Sealed class representing different states of a View in the UI.
 * This class is used to represent various states that a View can be in,
 * such as loading, empty, success, and error.
 */
sealed class ViewState {

    /**
     * Represents the Loading state, indicating that data is being loaded.
     */
    data object Loading : ViewState()

    /**
     * Represents the Empty state, indicating that no data is available.
     */
    data object Empty : ViewState()

    /**
     * Represents the Success state, which contains the data when the operation is successful.
     *
     * @param data The data returned from a successful operation. This can be any type.
     */
    data class Success(val data: Any?) : ViewState()

    /**
     * Represents the Error state, which contains a message describing the error.
     *
     * @param message The error message to describe the problem that occurred.
     */
    data class Error(val message: String) : ViewState()
}