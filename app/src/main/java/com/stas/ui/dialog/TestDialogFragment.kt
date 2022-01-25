package com.stas.ui.dialog

import android.app.Dialog
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.DialogFragment
import com.stas.appfortest.R

class TestDialogFragment : DialogFragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val v: View = inflater.inflate(R.layout.fragment_dialog_test, container, false)
    return v;
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val dialog =  super.onCreateDialog(savedInstanceState)
    //dialog.getWindow()?.requestFeature(Window.FEATURE_NO_TITLE);
    return dialog;
  }

  override fun onResume() {
    super.onResume()
    val dialog = dialog
    val p = Point()
    activity!!.windowManager.defaultDisplay.getSize(p)
    Log.d("TEST32", p.y.toString())
    val window = dialog!!.window;
    val params : WindowManager.LayoutParams = window!!.attributes
    params.width = 800
    params.height = 800
    window.attributes = params
  }

}