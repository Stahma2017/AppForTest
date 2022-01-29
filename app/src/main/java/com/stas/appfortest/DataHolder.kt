package com.stas.appfortest

import com.stas.ui.main.MainActivity
import com.stas.ui.main.SamplesAdapter

object DataHolder {
  val samples = mutableListOf<SamplesAdapter.SampleItem>(
    SamplesAdapter.SampleItem("Simple Dialog", MainActivity.Screen.DIALOG_FRAGMENT),
    SamplesAdapter.SampleItem("Coordinator", MainActivity.Screen.COORDINATOR)
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
}