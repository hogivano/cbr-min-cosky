package com.trydev.cbr.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.trydev.cbr.R
import com.trydev.cbr.adapter.IndicationAdapter
import com.trydev.cbr.contract.IndicationContract
import com.trydev.cbr.model.Indication
import com.trydev.cbr.presenter.IndicationPresenter
import kotlinx.android.synthetic.main.fragment_indication.*



/**
 * A simple [Fragment] subclass.
 */
class IndicationFragment : Fragment(), IndicationContract.View {

    private lateinit var rvIndication : RecyclerView
    private lateinit var presenter : IndicationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvIndication = rv_indication
        presenter = IndicationPresenter()
        presenter.attachView(this, requireContext())
        presenter.getList()

    }

    override fun listIndication(list: ArrayList<Indication>) {
        rvIndication.layoutManager = LinearLayoutManager(requireContext())
        rvIndication.adapter = IndicationAdapter(requireContext(), list)
    }

    override fun onLoading() {
    }

    override fun onError(msg: String) {
    }

    override fun onSuccess(msg: String) {
    }
}
