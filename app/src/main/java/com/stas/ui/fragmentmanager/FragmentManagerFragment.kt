package com.stas.ui.fragmentmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.stas.appfortest.R
import com.stas.ui.dialog.TestDialogFragment

class FragmentManagerFragment : Fragment() {

  lateinit var action: Button

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_fragment_manager, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    bindViews(view)
    prepareUi()
  }

  private fun prepareUi() {
    action.setOnClickListener {
      val fragment = childFragmentManager.findFragmentByTag("TEST")
      if (fragment == null) {
        childFragmentManager.commit {
          addToBackStack("test")
          add<TestDialogFragment>(R.id.fragment_container, "TEST")
        }
      } else {
        if (fragment.isVisible) {
          childFragmentManager.commit {
            hide(fragment)
          }
        } else {
          childFragmentManager.commit {
            show(fragment)
          }
        }

      }

    }
  }

  private fun bindViews(view: View) {
    action = view.findViewById(R.id.action)
  }
}