package com.stas.ui.blureffect

import android.annotation.SuppressLint
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.slider.Slider
import com.stas.appfortest.R
import com.stas.ui.blureffect.blureffectslist.BlurEffectsListFragment
import com.stas.ui.main.MainActivity

class BlurEffectActivity : AppCompatActivity() {
  private lateinit var image: ImageView
  private lateinit var sliderX: Slider
  private lateinit var sliderY: Slider
  private lateinit var checkbox: MaterialCheckBox
  private lateinit var button: MaterialButton
  private lateinit var container: FragmentContainerView

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
      } else {
        image.setRenderEffect(null)
      }
    }

    button.setOnClickListener {
      navigateTo(Screen.BLUR_EFFECT_LIST)
    }

  }

  private fun bindViews() {
    image = findViewById(R.id.blur_activity_image)
    sliderX = findViewById(R.id.blur_activity_slider_x)
    sliderY = findViewById(R.id.blur_activity_slider_y)
    checkbox = findViewById(R.id.blur_activity_checkbox)
    button = findViewById(R.id.blur_activity_next)
    container = findViewById(R.id.blur_activity_container)
  }

  private fun navigateTo(screen: Screen) {
    when (screen) {
      Screen.BLUR_EFFECT_LIST -> {
        supportFragmentManager.commit {
          replace<BlurEffectsListFragment>(R.id.blur_activity_container)
        }
      }
      else -> {}
    }
  }

  enum class Screen {
    BLUR_EFFECT_LIST
  }

}