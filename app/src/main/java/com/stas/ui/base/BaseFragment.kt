package com.stas.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.stas.ui.main.MainActivity

abstract class BaseFragment<Binding : ViewBinding> : Fragment() {

  private var _binding: Binding? = null
  protected val binding get() = _binding!!

  abstract fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?): Binding

  open fun prepareUi(savedInstanceState: Bundle?) = Unit

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    _binding = provideViewBinding(inflater, container)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    prepareUi(savedInstanceState)
  }

  protected fun navigateTo(screen: MainActivity.Screen) {
    (activity as MainActivity).navigateTo(screen)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}