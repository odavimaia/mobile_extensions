package com.example.kotlin_extensions.extensions

import android.view.View
import com.example.kotlin_extensions.data.ViewState

/**
 * Sets the visibility of the `View` to VISIBLE, making it visible in the UI.
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Sets the visibility of the `View` to INVISIBLE, making it invisible but still taking up space in the layout.
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * Sets the visibility of the `View` to GONE, making it completely hidden and not taking up space in the layout.
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * Handles the different states of a `View` (Success, Error, Empty, Loading) based on the provided `ViewState`.
 * This function allows executing specific callbacks for each state.
 *
 * @param state The `ViewState` representing the current state (Success, Error, Empty, or Loading).
 * @param callbackError Optional callback function to handle the Error state.
 * @param callbackEmpty Optional callback function to handle the Empty state.
 * @param callbackLoading Optional callback function to handle the Loading state.
 * @param callbackSuccess Optional callback function to handle the Success state and provide the data.
 */
fun coroutineViewState(
    state: ViewState,
    callbackError: ((String) -> Unit)? = null,
    callbackEmpty: (() -> Unit)? = null,
    callbackLoading: (() -> Unit)? = null,
    callbackSuccess: ((Any?) -> Unit)? = null
) {
    when (state) {
        is ViewState.Success -> callbackSuccess?.invoke(state.data) // Handle Success state
        is ViewState.Error -> callbackError?.invoke(state.message) // Handle Error state
        is ViewState.Empty -> callbackEmpty?.invoke() // Handle Empty state
        is ViewState.Loading -> callbackLoading?.invoke() // Handle Loading state
    }
}