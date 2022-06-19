package com.stas.ui.mnogoru

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.stas.appfortest.databinding.FragmentMnogoruBinding
import com.stas.ui.base.BaseFragment
import com.stas.ui.main.MainActivity

class MnogoruFragment : BaseFragment<FragmentMnogoruBinding>() {

  override fun provideViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentMnogoruBinding = FragmentMnogoruBinding.inflate(inflater, container, false)

  override fun prepareUi(savedInstanceState: Bundle?) {
    binding.action.setOnClickListener {
      navigateTo(MainActivity.Screen.MNOGORU_CHARTS)
    }
  }

}