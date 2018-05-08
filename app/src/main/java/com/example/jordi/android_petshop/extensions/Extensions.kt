package com.example.jordi.android_petshop.extensions

import android.content.Context
import android.os.Build
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.text.Html
import android.text.Spanned
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.rengwuxian.materialedittext.MaterialEditText
//import com.worldline.data.constants.Constants
//import com.worldline.reinasofiaactivos.R
//import com.worldline.reinasofiaactivos.model.MovementView
import java.text.SimpleDateFormat
import java.util.*


/**
 * Extensions.
 */

/**
 * Context
 * */
fun Context.toast(text: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, length).show()
}

fun Context.toast(textId: Int, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, textId, length).show()
}
