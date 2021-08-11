package com.architectcoders.myapplication

import android.os.Bundle

// constant
const val EXTRA_PASSWORD_STATE_DIALOG_FRAGMENT = "aaa"

// extension function
fun Bundle.putEnum(key: String, enum: Enum<*>) {
    putString(key, enum.name)
}