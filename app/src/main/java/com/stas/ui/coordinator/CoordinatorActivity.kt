package com.stas.ui.coordinator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.stas.appfortest.R

class CoordinatorActivity : AppCompatActivity() {

  lateinit var toolbar: MaterialToolbar
  lateinit var container: FragmentContainerView
  lateinit var coordinator: CoordinatorLayout
  lateinit var appBar: AppBarLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_coordinator)
    supportFragmentManager.commit {
      setReorderingAllowed(true)
      addToBackStack(null)
      add<CoordinatorFragment>(R.id.fragments_container)
    }
    bindViews()
    prepareViews()
  }

  private fun prepareViews() { }

  private fun setupBehavior() {
    val tabBarHeight = resources.getDimension(R.dimen.app_bar_height)
    val behavior = ContentBehavior(true, 0, tabBarHeight.toInt())
    val navParams = toolbar.layoutParams as AppBarLayout.LayoutParams
    navParams.scrollFlags = (AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
            or AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
            or AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL)
    toolbar.layoutParams = navParams
    val containerParams = container.layoutParams as AppBarLayout.LayoutParams
    if (behavior != null) {
      behavior.onDependentViewChanged(coordinator, container, appBar)
    }
  }

  private fun bindViews() {
    coordinator = findViewById(R.id.coordinator)
    appBar = findViewById(R.id.app_bar)
    toolbar = findViewById(R.id.coordinator_toolbar)
    container = findViewById(R.id.fragments_container)
  }
}