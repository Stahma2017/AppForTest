package com.stas.textwatcher2

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText

open class MaskedTextChangedListener2(val editText: EditText) : TextWatcher {

  override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    Log.d("TEST25", "beforeTextChanged()")
  }

  override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    Log.d("TEST25", "onTextChanged()")
  }

  override fun afterTextChanged(editable: Editable?) {
    Log.d("TEST25", "afterTextChanged()")
    editable?.replace(0, editable.length, "test")
  }

}