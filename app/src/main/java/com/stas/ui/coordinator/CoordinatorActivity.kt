package com.stas.ui.coordinator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stas.appfortest.R

class CoordinatorActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_coordinator)
    bindViews()
    prepareViews()
  }

  private fun prepareViews() {

  }

  private fun bindViews() {
  }
}