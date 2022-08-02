package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentSideMenuBinding
import com.onuremren.googleyemekapp.model.OrderViewModel


class SideMenuFragment : Fragment() {

    private var _binding : FragmentSideMenuBinding ?= null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSideMenuBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            sideMenuFragment = this@SideMenuFragment
        }
    }

    fun goToNextScreen(){
        findNavController().navigate(R.id.action_sideMenuFragment_to_accompanimentMenuFragment)
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_sideMenuFragment_to_entreeMenuFragment)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}