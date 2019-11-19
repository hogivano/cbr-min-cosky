package com.trydev.cbr.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView

import com.trydev.cbr.R
import kotlinx.android.synthetic.main.fragment_solution.*



/**
 * A simple [Fragment] subclass.
 */
class SolutionFragment : Fragment() {

    private lateinit var rvSolution : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_solution, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSolution = rv_solution
        var list : ArrayList<String>
        list = ArrayList()
        list.add("okee")
        list.add("okee")
    }

}
