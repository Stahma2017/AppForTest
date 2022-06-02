package com.stas.ui.mlkit

import android.view.LayoutInflater
import android.view.ViewGroup
import com.stas.appfortest.databinding.FragmentMlKitBinding
import com.stas.ui.base.BaseFragment

class MlKitFragment : BaseFragment<FragmentMlKitBinding>() {

  override fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMlKitBinding =
    FragmentMlKitBinding.inflate(inflater, container, false)

}