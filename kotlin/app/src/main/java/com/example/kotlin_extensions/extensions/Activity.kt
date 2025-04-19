package com.example.kotlin_extensions.extensions

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver

/**
 * Monitors the visibility of the keyboard in an [Activity].
 * It triggers the [isOpen] callback whenever the keyboard is shown or hidden.
 *
 * @param isOpen A lambda function that will be called with a [Boolean] value:
 *               - `true` if the keyboard is open.
 *               - `false` if the keyboard is closed.
 */
fun Activity.keyboardListener(isOpen: (Boolean) -> Unit) {
    val rootView = window.decorView.findViewById<View>(android.R.id.content)

    rootView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        private var wasOpened = false

        override fun onGlobalLayout() {
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect)
            val screenHeight = rootView.rootView.height
            val keypadHeight = screenHeight - rect.bottom
            val isKeyboardNowOpen = keypadHeight > screenHeight * 0.15

            // Only trigger callback if the keyboard's state has changed
            if (wasOpened != isKeyboardNowOpen) {
                isOpen(isKeyboardNowOpen)
                wasOpened = isKeyboardNowOpen
            }
        }
    })
}