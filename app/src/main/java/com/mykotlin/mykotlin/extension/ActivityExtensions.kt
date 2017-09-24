package com.mykotlin.mykotlin.extension

import android.app.Activity
import android.widget.Toast

/**
 * Created by pedro on 24/09/2017.
 */

fun Activity.showShortToast(text: String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}