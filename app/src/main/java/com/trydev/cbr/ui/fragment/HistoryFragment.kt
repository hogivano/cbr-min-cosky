package com.trydev.cbr.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.trydev.cbr.R
import com.trydev.cbr.adapter.HistoryAdapter
import com.trydev.cbr.contract.HistoryContract
import com.trydev.cbr.contract.HomeContract
import com.trydev.cbr.model.History
import com.trydev.cbr.model.Indication
import com.trydev.cbr.presenter.HistoryPresenter
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.item_check.*

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment(), HistoryContract.View{
    private lateinit var rv : RecyclerView
    private lateinit var presenter : HistoryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = rv__history
        presenter = HistoryPresenter()
        presenter.attachView(this, requireContext())
        presenter.getList()
    }

    override fun listHistory(list: ArrayList<History>) {
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = HistoryAdapter(requireContext(), list)
    }

    override fun onLoading() {
    }

    override fun onError(msg: String) {
    }

    override fun onSuccess(msg: String) {
    }
}
