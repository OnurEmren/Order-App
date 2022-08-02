package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentStartOrderBinding


class StartOrderFragment : Fragment() {

    private var _binding: FragmentStartOrderBinding ?= null
    private val binding get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartOrderBinding.inflate(inflater,container,false)
        val root : View = binding!!.root
        binding?.startOrderBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_startOrderFragment_to_entreeMenuFragment)
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}