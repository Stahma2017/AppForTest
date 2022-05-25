package com.stas.ui.blureffect.blureffectslist

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stas.appfortest.DataHolder
import com.stas.appfortest.R
import com.stas.ui.blureffect.blureffectslist.adapter.BlurSamplesAdapter
import com.stas.ui.main.VerticalItemDecoration

class BlurEffectsListFragment : Fragment() {

  private var blurRadiusX = 2f
  private var blurRadiusY = 2f

  lateinit var list: RecyclerView
  lateinit var bottomNavigation: BottomNavigationView
  private val adapter : BlurSamplesAdapter = BlurSamplesAdapter()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_blur_effects_list, container, false)
    bindViews(view)
    return view
  }

  @RequiresApi(Build.VERSION_CODES.S)
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    prepareUi()
  }

  @RequiresApi(Build.VERSION_CODES.S)
  private fun prepareUi() {
    list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    list.adapter = adapter
    list.addItemDecoration(VerticalItemDecoration(20))
    adapter.items = DataHolder.blurFragmentItems
    bottomNavigation.setRenderEffect(RenderEffect.createBlurEffect(blurRadiusX, blurRadiusY, Shader.TileMode.MIRROR))
  }

  private fun bindViews(view: View) {
    list = view.findViewById(R.id.blur_effects_list)
    bottomNavigation = view.findViewById(R.id.blur_effects_bottom_nav)
  }
}