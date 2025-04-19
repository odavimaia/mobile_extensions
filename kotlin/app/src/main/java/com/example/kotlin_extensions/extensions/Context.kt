package com.example.kotlin_extensions.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Process


/**
 * Opens a URL in the default web browser.
 *
 * @param url The URL to be opened.
 */
fun Context.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(intent)
}

/**
 * Restarts the current app by launching the main activity again.
 *
 * This method uses the package manager to get the launch intent for the app
 * and then restarts the app by making the main activity task restart.
 */
fun Context.restartApp() {
    val packageManager = packageManager
    val intent = packageManager.getLaunchIntentForPackage(packageName)
    val mainIntent = Intent.makeRestartActivityTask(intent?.component)
    startActivity(mainIntent)
    Process.killProcess(Process.myPid()) // Terminates the current process to restart the app
}
