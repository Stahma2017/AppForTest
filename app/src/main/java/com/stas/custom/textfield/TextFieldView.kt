package com.stas.custom.textfield

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import androidx.core.widget.addTextChangedListener
import com.movix.android.uikit.textfield.EndIconMode
import com.movix.android.uikit.textfield.Mode
import com.stas.appfortest.R
import com.stas.appfortest.databinding.TextFieldViewBinding
import com.stas.toggleVisibility
import kotlin.properties.Delegates

class TextFieldView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  var currentInputType: TextFieldInputType by Delegates.observable(TextFieldInputType.Text) { _, _, value ->
    syncInputType(value)
  }

  private val binding = TextFieldViewBinding.inflate(LayoutInflater.from(context), this)

  private var hasError: Boolean by Delegates.observable(false) { _, _, _ -> syncMode() }

  private var isInputVisibleInPasswordMode: Boolean by Delegates.observable(false) { _, _, _ ->
    syncInputType(currentInputType)
  }

  private var endIconMode = EndIconMode.Clear

  private val closeIcon = R.drawable.ic_close
  private val passwordVisibleIcon = R.drawable.ic_visible
  private val passwordInvisibleIcon = R.drawable.ic_invisible

  // сохранение typeface из XML, чтобы вернуть его после смены InputType
  private val savedTypeface = binding.editText.typeface

  init {
    context.withStyledAttributes(attrs, R.styleable.TextFieldView) {
      val inputTypeIndex = getInt(R.styleable.TextFieldView_textFieldInputType, 0)
      check(inputTypeIndex < TextFieldInputType.values().size) {
        "Аттрибут textFieldInputType ссылается на несуществующий тип $inputTypeIndex"
      }
      currentInputType = TextFieldInputType.values()[inputTypeIndex]
    }

    binding.editText.setOnFocusChangeListener { _, hasFocus -> syncMode(hasFocus) }
    binding.editText.addTextChangedListener(
      afterTextChanged = {
        hasError = false
        binding.endImage.toggleVisibility(it?.length ?: 0 > 0)
      }
    )
    binding.endImage.setOnClickListener {
      val valForExhausted = when (endIconMode) {
        EndIconMode.Clear -> binding.editText.setText("")
        EndIconMode.TogglePasswordVisibility ->
          isInputVisibleInPasswordMode = !isInputVisibleInPasswordMode
      }
    }
    syncInputType(currentInputType)
  }

  fun getInputView() = binding.editText

  fun setHint(hintText: String) {
    binding.editText.hint = hintText
  }

  fun setError(errorText: String) {
    binding.error.text = errorText
    hasError = true
  }

  fun setDescriptionText(descriptionText: String) {
    binding.description.text = descriptionText
    binding.description.toggleVisibility(descriptionText.isNotBlank())
  }

  fun toggleDescriptionText(isVisible: Boolean) {
    binding.description.toggleVisibility(isVisible)
  }

  private fun syncMode(editTextHasFocus: Boolean = binding.editText.hasFocus()) {
    val newMode = when {
      hasError -> Mode.Error
      editTextHasFocus -> Mode.Edit
      else -> {
        val isEmptyText = binding.editText.text.toString().isEmpty()
        if (isEmptyText) Mode.Empty else Mode.Fill
      }
    }
    binding.border.mode = newMode

    if (!hasError) binding.error.text = ""
    binding.error.toggleVisibility(hasError && binding.error.text.isNotBlank())
  }

  private fun syncInputType(type: TextFieldInputType) {
      Log.d("TEST42", "syncInputType() = $type")
    val (inputType, endIconMode) = when (type) {
      TextFieldInputType.Text -> InputType.TYPE_CLASS_TEXT to EndIconMode.Clear
      TextFieldInputType.Digits -> InputType.TYPE_CLASS_NUMBER to EndIconMode.Clear
      TextFieldInputType.TextPassword -> {
        val password = if (isInputVisibleInPasswordMode) {
          InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
          InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        InputType.TYPE_CLASS_TEXT or password to EndIconMode.TogglePasswordVisibility
      }
      TextFieldInputType.DigitPassword -> {
        val password = if (isInputVisibleInPasswordMode) {
          InputType.TYPE_NUMBER_VARIATION_NORMAL
        } else {
          InputType.TYPE_NUMBER_VARIATION_PASSWORD
        }
        InputType.TYPE_CLASS_NUMBER or password to EndIconMode.TogglePasswordVisibility
      }
    }

    val textLength = binding.editText.length()

    binding.editText.inputType = inputType
    binding.editText.typeface = savedTypeface
    binding.editText.setSelection(textLength)

    this.endIconMode = endIconMode
    val endIconDrawableId = when (endIconMode) {
        EndIconMode.Clear -> closeIcon
        EndIconMode.TogglePasswordVisibility -> {
            if (isInputVisibleInPasswordMode) passwordVisibleIcon else passwordInvisibleIcon
        }
    }
    binding.endImage.setImageResource(endIconDrawableId)
    binding.endImage.toggleVisibility(textLength > 0)
  }
}