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
import com.trydev.cbr.model.Indication
import kotlinx.android.synthetic.main.fragment_indication.*



/**
 * A simple [Fragment] subclass.
 */
class IndicationFragment : Fragment() {

    private lateinit var rvIndication : RecyclerView

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
        initData()

    }

    private fun initData(){
        var list : ArrayList<Indication>
        list = ArrayList()
        list.add(Indication(1, "Nyeri Dada", 0.7))
        list.add(Indication(2, "Sesak Nafas", 0.6))
        list.add(Indication(3, "Keringat Dingin", 0.5))
        list.add(Indication(4, "Pembengkakan Kaki", 0.7))
        list.add(Indication(5, "Mudah Lelah", 0.6))
        list.add(Indication(6, "Batuk Kering", 0.2))
        list.add(Indication(7, "Sakit Leher/Punggung", 0.4))
        list.add(Indication(8, "Kelainan Bunyi Jatung", 0.2))

        rvIndication.layoutManager = LinearLayoutManager(requireContext())
        rvIndication.adapter = IndicationAdapter(requireContext(), list)
    }
}
