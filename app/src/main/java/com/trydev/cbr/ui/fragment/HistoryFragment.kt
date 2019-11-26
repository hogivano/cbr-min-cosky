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
import com.trydev.cbr.model.History
import com.trydev.cbr.model.Indication
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.item_check.*

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {
    private lateinit var rv : RecyclerView

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
        initData()
    }

    private fun initData(){
        var list : ArrayList<History>
        list = ArrayList()

        var indication1 : ArrayList<Indication> = ArrayList()
        indication1.add(
            Indication(2, "Sesak Nafas", 0.6)
        )
        indication1.add(
            Indication(8, "Kelainan Bunyi Jatung", 0.2)
        )
        indication1.add(
            Indication(3, "Keringat Dingin", 0.5)
        )

        var indication2 : ArrayList<Indication> = ArrayList()
        indication2.add(
            Indication(2, "Sesak Nafas", 0.6)
        )
        indication2.add(
            Indication(5, "Mudah Lelah", 0.6)
        )

        var indication3 : ArrayList<Indication> = ArrayList()
        indication3.add(
            Indication(6, "Batuk Kering", 0.2)
        )
        indication3.add(
            Indication(7, "Sakit Leher/Punggung", 0.4)
        )
        indication3.add(
            Indication(4, "Pembengkakan Kaki", 0.7)
        )

        var indication4 : ArrayList<Indication> = ArrayList()
        indication4.add(
            Indication(3, "Keringat Dingin", 0.5)
        )
        indication4.add(
            Indication(1, "Nyeri Dada", 0.7)
        )
        indication4.add(
            Indication(8, "Kelainan Bunyi Jatung", 0.2)
        )

        var indication5 : ArrayList<Indication> = ArrayList()
        indication5.add(
            Indication(8, "Kelainan Bunyi Jatung", 0.2)
        )
        indication5.add(
            Indication(4, "Pembengkakan Kaki", 0.7)
        )
        indication5.add(
            Indication(3, "Keringat Dingin", 0.5)
        )
        indication5.add(
            Indication(5, "Mudah Lelah", 0.6)
        )

        list.add(
            History(
                1,
                "Serangan Jantung",
                indication1
            )
        )
        list.add(
            History(
                2,
                "Gagal Jantung",
                indication2
            )
        )
        list.add(
            History(
                3,
                "Gagal Jantung",
                indication3
            )
        )
        list.add(
            History(
                4,
                "Gagal Jantung",
                indication4
            )
        )
        list.add(
            History(
                5,
                "Serangan Jantung",
                indication5
            )
        )

        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = HistoryAdapter(requireContext(), list)
    }
}
