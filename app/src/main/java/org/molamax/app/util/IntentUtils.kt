package org.molamax.app.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun dialPhone(context: Context, phone: String) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phone.replace(" ", "")}"))
    context.startActivity(intent)
}

fun sendEmail(context: Context, email: String, subject: String = "") {
    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")).apply {
        if (subject.isNotEmpty()) putExtra(Intent.EXTRA_SUBJECT, subject)
    }
    context.startActivity(intent)
}

fun openUrl(context: Context, url: String) {
    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}
