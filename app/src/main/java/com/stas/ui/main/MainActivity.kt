package com.stas.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stas.appfortest.DataHolder
import com.stas.appfortest.R
import com.stas.ui.bitmaptransformations.BitmapTransformationsFragment
import com.stas.ui.blureffect.BlurEffectActivity
import com.stas.ui.complexbackgroun.ComplexBackgroundFragment
import com.stas.ui.coordinator.CoordinatorActivity
import com.stas.ui.dialog.TestDialogFragment
import com.stas.ui.fragmentmanager.FragmentManagerFragment
import com.stas.ui.glide.GlideFragment

class MainActivity : AppCompatActivity() {
  lateinit var samples: RecyclerView

  private val adapter: SamplesAdapter = SamplesAdapter { sampleType ->
    navigateTo(sampleType)
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    bindViews()
    prepareViews()
  }

  private fun prepareViews() {
    setupSamples()
  }

  private fun setupSamples() {
    samples.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    samples.adapter = adapter
    samples.addItemDecoration(VerticalItemDecoration(20))
    adapter.items = DataHolder.samples
  }

  private fun bindViews() {
    samples = findViewById(R.id.samples)
  }

  private fun navigateTo(screen: Screen) {
    when (screen) {
      /*Screen.IMAGE_MATRIX_FRAGMENT -> {
        supportFragmentManager.commit {
          setReorderingAllowed(true)
          addToBackStack(screen.name)
          add<ImageMatrixFragment>(R.id.fragment_container)
        }
      }*/
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
    BLUR_EFFECT
  }
}