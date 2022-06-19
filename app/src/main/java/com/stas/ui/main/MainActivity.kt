package com.stas.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.stas.appfortest.R
import com.stas.ui.bitmaptransformations.BitmapTransformationsFragment
import com.stas.ui.blureffect.BlurEffectActivity
import com.stas.ui.bottomsheet.BottomsheetFragment
import com.stas.ui.chart.ChartsFragment
import com.stas.ui.complexbackgroun.ComplexBackgroundFragment
import com.stas.ui.coordinator.CoordinatorActivity
import com.stas.ui.dialog.TestDialogFragment
import com.stas.ui.fragmentmanager.FragmentManagerFragment
import com.stas.ui.glide.GlideFragment
import com.stas.ui.mnogoru.MnogoruFragment

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    prepareViews()
    if (savedInstanceState == null) {
      navigateTo(Screen.MAIN_ROOT)
    }
  }

  private fun prepareViews() { }

  fun navigateTo(screen: Screen) {
    when (screen) {
      Screen.DIALOG_FRAGMENT -> {
        TestDialogFragment().show(supportFragmentManager, "dialog")
      }
      Screen.COORDINATOR -> {
        startActivity(Intent(this, CoordinatorActivity::class.java))
      }
      Screen.COMPLEX_BACKGROUND -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<ComplexBackgroundFragment>(R.id.fragment_container)
        }
      }
      Screen.FRAGMENT_MANAGER -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<FragmentManagerFragment>(R.id.fragment_container)
        }
      }
      Screen.GLIDE -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<GlideFragment>(R.id.fragment_container)
        }
      }
      Screen.BITMAP_TRANSFORMATIONS -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<BitmapTransformationsFragment>(R.id.fragment_container)
        }
      }
      Screen.BLUR_EFFECT -> {
        startActivity(Intent(this, BlurEffectActivity::class.java))
      }
      Screen.BOTTOMSHEET -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<BottomsheetFragment>(R.id.fragment_container)
        }
      }
      Screen.MAIN_ROOT -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          replace<MainFragment>(R.id.fragment_container)
        }
      }
      Screen.MNOGORU -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<MnogoruFragment>(R.id.fragment_container)
        }
      }
      Screen.MNOGORU_CHARTS -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<ChartsFragment>(R.id.fragment_container)
        }
      }
    }
  }

  enum class Screen {
    NONE,
    DIALOG_FRAGMENT,
    COORDINATOR,
    COMPLEX_BACKGROUND,
    FRAGMENT_MANAGER,
    GLIDE,
    BITMAP_TRANSFORMATIONS,
    BLUR_EFFECT,
    BOTTOMSHEET,
    MAIN_ROOT,
    MNOGORU,
    MNOGORU_CHARTS
  }
}