package com.stas.ui.glide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.stas.appfortest.R

class GlideFragment : Fragment() {

  lateinit var image: ImageView

  val url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyV-agmC4dh4pZ94ItyA29hYgrpXjX2_uB7-Z6010scENP-Eu8sXesFFfBmkjDKhtXN-U&usqp=CAU"

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_glide, container, false)
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    bindViews(view)
    prepareUi()
  }


  private fun prepareUi() {
      Glide.with(this)
        .load(url)
        .into(image)
  }

  private fun bindViews(view: View) {
    image = view.findViewById(R.id.image)
  }
}