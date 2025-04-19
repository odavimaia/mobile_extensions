package com.example.kotlin_extensions.extensions

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.widget.TextView
import android.view.View
import android.graphics.Color

/**
 * Makes portions of the text in a `TextView` clickable and executes the associated
 * `OnClickListener` when clicked.
 *
 * This function allows you to define multiple links within the `TextView`, where
 * each link is represented by a `Pair<String, View.OnClickListener>`. The string in
 * the pair will be clickable, and clicking it will trigger the `OnClickListener`.
 *
 * Optionally, a custom `Typeface` can be applied to the clickable text.
 *
 * @param links A list of pairs where each pair contains a string to be made clickable and
 *              its corresponding `OnClickListener` to be triggered upon click.
 * @param typeface An optional custom `Typeface` to be applied to the clickable text.
 */
fun TextView.makeLinks(
    vararg links: Pair<String, View.OnClickListener>,
    typeface: Typeface? = null
) {
    val spannableString = SpannableString(text) // Create a SpannableString from the TextView text
    links.forEach { pair ->
        val startIndex = text.indexOf(pair.first) // Find the start index of the link
        if (startIndex >= 0) {
            val endIndex = startIndex + pair.first.length // Find the end index of the link
            val clickableSpan = object : ClickableSpan() { // Create the clickable span
                override fun onClick(widget: View) {
                    pair.second.onClick(widget) // Call the onClick listener
                }

                override fun updateDrawState(ds: android.text.TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false // Remove underline from the clickable text
                    typeface?.let { ds.typeface = it } // Apply custom typeface if provided
                }
            }
            spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // Set the clickable span
        }
    }
    movementMethod = LinkMovementMethod.getInstance() // Make the TextView clickable
    setText(spannableString, TextView.BufferType.SPANNABLE) // Set the spannable text back to the TextView
}

/**
 * Sets the text color of the `TextView` using a hexadecimal color code.
 *
 * This function parses the given color string (in the format "#RRGGBB" or "#AARRGGBB")
 * and applies it to the `TextView`. If the color string is invalid, no change is made.
 *
 * @param color The color string in hexadecimal format (e.g., "#FF5733").
 */
fun TextView.setTextColorHex(color: String) {
    try {
        setTextColor(Color.parseColor(color)) // Try to parse the color string and apply it
    } catch (_: IllegalArgumentException) {
        //invalid color, do nothing
    }
}