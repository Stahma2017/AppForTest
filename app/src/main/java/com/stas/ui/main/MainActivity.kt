package com.stas.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stas.appfortest.DataHolder
import com.stas.appfortest.R
import com.stas.ui.coordinator.CoordinatorActivity
import com.stas.ui.dialog.TestDialogFragment

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
    }
  }

  enum class Screen {
    IMAGE_MATRIX_FRAGMENT,
    DIALOG_FRAGMENT,
    COORDINATOR
  }
}