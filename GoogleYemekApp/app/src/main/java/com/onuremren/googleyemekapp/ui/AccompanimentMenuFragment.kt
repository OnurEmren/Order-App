package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentAccompanimentMenuBinding
import com.onuremren.googleyemekapp.model.OrderViewModel


class AccompanimentMenuFragment : Fragment() {

    private var _binding: FragmentAccompanimentMenuBinding ?= null
    private val binding get() = _binding!!
    private val sharedViewModel: OrderViewModel by activityViewModels(

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccompanimentMenuBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            accompanimentMenuFragment = this@AccompanimentMenuFragment


        }
    }

    fun goToNextScreen(){
        findNavController().navigate(R.id.action_accompanimentMenuFragment_to_checkoutFragment)
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_accompanimentMenuFragment_to_sideMenuFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}