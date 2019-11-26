package com.trydev.cbr.ui.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.trydev.cbr.R
import com.trydev.cbr.ResultActivity
import com.trydev.cbr.adapter.CheckProblemAdapter
import com.trydev.cbr.contract.HomeContract
import com.trydev.cbr.model.Indication
import com.trydev.cbr.presenter.HomePresenter
import com.trydev.cbr.utils.OnCheckedIndicationListener
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.DecimalFormat

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), OnCheckedIndicationListener, HomeContract.View {
    lateinit var rv : RecyclerView
    lateinit var btnFind : Button
    private lateinit var presenter: HomePresenter
    private lateinit var decimalFormat : DecimalFormat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = rv_indication
        btnFind = btn_find
        presenter = HomePresenter(this)
        decimalFormat = DecimalFormat("#.##")

        initData()

        btnFind.setOnClickListener {
            presenter.find()
        }
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

        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = CheckProblemAdapter(requireContext(), list, this)
    }

    override fun onChecked(indication: Indication) {
        presenter.setIndication(indication)
        presenter.printListIndication()
    }

    override fun notChecked(indication: Indication) {
        presenter.removeIndication(indication)
        presenter.printListIndication()
    }

    override fun result(solution: String, strIndication: String) {
        startActivity(
            Intent(activity, ResultActivity::class.java)
                .putExtra("strIndication", strIndication)
                .putExtra("solution", solution)
        )
    }

    override fun onLoading() {
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(msg: String) {
    }
}
