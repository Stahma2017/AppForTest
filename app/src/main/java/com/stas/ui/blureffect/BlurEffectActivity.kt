package com.stas.ui.blureffect

import android.annotation.SuppressLint
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.slider.Slider
import com.stas.appfortest.R

class BlurEffectActivity : AppCompatActivity() {
  lateinit var image: ImageView
  lateinit var sliderX: Slider
  lateinit var sliderY: Slider
  lateinit var checkbox: MaterialCheckBox

  var blurRadiusX = 1f
  var blurRadiusY = 1f

  @SuppressLint("NewApi")
  var blurEffect = RenderEffect.createBlurEffect(blurRadiusX, blurRadiusY, Shader.TileMode.MIRROR)

  @RequiresApi(Build.VERSION_CODES.S)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.blur_activity)
    bindViews()
    prepareView()
  }

  @RequiresApi(Build.VERSION_CODES.S)
  private fun prepareView() {
    image.setRenderEffect(blurEffect)

    sliderX.addOnChangeListener { slider, value, fromUser ->
      blurRadiusX = value
      blurEffect = RenderEffect.createBlurEffect(blurRadiusX, blurRadiusY, Shader.TileMode.MIRROR)
      if (checkbox.isChecked) {
        image.setRenderEffect(blurEffect)
      }
    }

    sliderY.addOnChangeListener { slider, value, fromUser ->
      blurRadiusY = value
      blurEffect = RenderEffect.createBlurEffect(blurRadiusX, blurRadiusY, Shader.TileMode.MIRROR)
      if (checkbox.isChecked) {
        image.setRenderEffect(blurEffect)
      }
    }

    checkbox.setOnCheckedChangeListener { compoundButton, isChecked ->
      if (isChecked) {
        image.setRenderEffect(blurEffect)
      }
      else {
        image.setRenderEffect(null)
      }
    }

  }

  private fun bindViews() {
    image = findViewById(R.id.blur_activity_image)
    sliderX = findViewById(R.id.blur_activity_slider_x)
    sliderY = findViewById(R.id.blur_activity_slider_y)
    checkbox = findViewById(R.id.blur_activity_checkbox)
  }

}