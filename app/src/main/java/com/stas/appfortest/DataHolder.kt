package com.stas.appfortest

import com.stas.ui.blureffect.blureffectslist.adapter.BlurSamplesAdapter
import com.stas.ui.main.MainActivity
import com.stas.ui.main.SamplesAdapter

object DataHolder {
  val samples = mutableListOf<SamplesAdapter.SampleItem>(
    SamplesAdapter.SampleItem("Simple Dialog", MainActivity.Screen.DIALOG_FRAGMENT),
    SamplesAdapter.SampleItem("Coordinator", MainActivity.Screen.COORDINATOR),
    SamplesAdapter.SampleItem("Complex Background", MainActivity.Screen.COMPLEX_BACKGROUND),
    SamplesAdapter.SampleItem("Fragment manager", MainActivity.Screen.FRAGMENT_MANAGER),
    SamplesAdapter.SampleItem("Glide", MainActivity.Screen.GLIDE),
    SamplesAdapter.SampleItem("Bitmap Trasnformations", MainActivity.Screen.BITMAP_TRANSFORMATIONS),
    SamplesAdapter.SampleItem("Blur effect", MainActivity.Screen.BLUR_EFFECT)
  )

  val coordinatorFragmentItems = mutableListOf<SamplesAdapter.SampleItem>(
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE),
    SamplesAdapter.SampleItem("Lorem ipsum dolor sit amet", MainActivity.Screen.NONE)
  )

  val blurFragmentItems = mutableListOf<BlurSamplesAdapter.BlurSampleItem>(
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_android),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art1),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art2),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_android),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art3),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art1),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_android),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art2),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art3),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art1),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_android),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art2),
    BlurSamplesAdapter.BlurSampleItem("Lorem ipsum dolor sit amet", R.drawable.pic_art3)
  )
}