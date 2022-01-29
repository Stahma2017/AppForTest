package com.stas.ui.coordinator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stas.appfortest.DataHolder
import com.stas.appfortest.R
import com.stas.ui.imagematrix.ImageMatrixFragment
import com.stas.ui.main.SamplesAdapter
import com.stas.ui.main.VerticalItemDecoration

class CoordinatorFragment : Fragment() {

  lateinit var list: RecyclerView
  private val adapter: SamplesAdapter = SamplesAdapter {
    parentFragmentManager.commit {
      setReorderingAllowed(true)
      addToBackStack(null)
      add<ImageMatrixFragment>(R.id.container)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_coordinator, container, false)
    bindViews(view)
    return view;
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    prepareViews()
  }

  private fun bindViews(view: View) {
    list = view.findViewById(R.id.list)
  }

  private fun prepareViews() {
    list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    list.adapter = adapter
    list.addItemDecoration(VerticalItemDecoration(20))
    adapter.items = DataHolder.coordinatorFragmentItems
  }
}