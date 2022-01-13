package com.movix.android.uikit.textfield

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class SelectionAwareEditText : AppCompatEditText {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var onSelectionChanges: ((selStart: Int, selEnd: Int?) -> Unit)? = null

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)
        onSelectionChanges?.invoke(selStart, selEnd)
    }

    fun setOnSelectionChangedListener(onSelectionChanges: (selStart: Int, selEnd: Int?) -> Unit) {
        this.onSelectionChanges = onSelectionChanges
    }
}