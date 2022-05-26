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
    SamplesAdapter.SampleItem("Blur effect", MainActivity.Screen.BLUR_EFFECT),
    SamplesAdapter.SampleItem("Bottomsheet", MainActivity.Screen.BOTTOMSHEET)
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

  val lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
          "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. " +
          "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. " +
          "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"
}