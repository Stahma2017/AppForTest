package com.stas.appfortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.stas.ui.gradientbackground.GradientBackgroundFragment
import com.stas.ui.imagematrix.ImageMatrixFragment

class MainActivity : AppCompatActivity() {
  lateinit var container: FragmentContainerView
  lateinit var gradientBackgroundAction: Button
  lateinit var imageMatrixAction: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    bindViews()
    prepareViews()
  }

  private fun prepareViews() {
    gradientBackgroundAction.setOnClickListener {
      navigateTo(Screen.GRADIENT_BACKGROUND)
    }
    imageMatrixAction.setOnClickListener {
      navigateTo(Screen.IMAGE_MATRIX)
    }
  }

  private fun bindViews() {
    container = findViewById(R.id.fragment_container)
    gradientBackgroundAction = findViewById(R.id.gradient_background_action)
    imageMatrixAction = findViewById(R.id.image_matrix_action)
  }

  private fun navigateTo(screen: Screen) {
    when (screen) {
      Screen.GRADIENT_BACKGROUND -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<GradientBackgroundFragment>(R.id.fragment_container)
        }
      }
      Screen.IMAGE_MATRIX -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<ImageMatrixFragment>(R.id.fragment_container)
        }
      }
    }
  }

  enum class Screen {
    GRADIENT_BACKGROUND,
    IMAGE_MATRIX
  }
}