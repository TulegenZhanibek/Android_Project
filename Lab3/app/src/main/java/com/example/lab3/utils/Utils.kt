package com.example.lab3.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.android.volley.BuildConfig

// Extension function to hide keyboard in a Fragment
fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

// Extension function to hide keyboard in a Context (Activity or Fragment context)
fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

// Extension function to check the state of the soft keyboard in a Fragment
fun Fragment.checkStateSoftKeyBoard(): Boolean {
    val inputMethodManager =
        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return inputMethodManager.isActive
}

// Extension function to check the state of the soft keyboard in a Context
fun Context.checkStateSoftKeyBoard(): Boolean {
    val inputMethodManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return inputMethodManager.isActive
}

// Utility function for debug printing
fun debugPrintln(s: String) {
    if (BuildConfig.DEBUG) {
        println("s = $s")
    }
}

// Commented-out functions that might be useful, depending on the project requirements:

//fun ammountStringWithDollar(view: TextView, s: String) {
//    val wordtoSpan: Spannable = SpannableString(s)
//    wordtoSpan.setSpan(
//        ForegroundColorSpan(ContextCompat.getColor(view.context, R.color.app_dollar)),
//        0,
//        3,
//        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//    )
//    view.text = wordtoSpan
//}

//fun setStringForPrice(context: Context, price: String): String {
//    return String.format(context.resources.getString(R.string.product_price), price)
//}

//fun simpleDialog(context: Context, message: String, title: String) {
//    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
//    builder.apply {
//        setPositiveButton("Ok") { dialog, _ -> }
//        setNegativeButton("Cancel") { dialog, _ -> }
//        setTitle(title)
//        setMessage(message)
//    }
//    builder.show()
//}

//fun setImageByGlide(context: Context, url: String, imageView: ImageView) {
//    Glide.with(context)
//        .load(url)
//        .placeholder(R.drawable.app_logo)
//        .into(imageView)
//}
