package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding
import kotlinx.android.synthetic.main.activity_main.*


class onBoardingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().toolbar.setTitle("Instructions")
        // Inflate the layout for this fragment
        val binding : FragmentOnBoardingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_on_boarding,container,false)
        binding.nextBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_onBoardingFragment_to_shoeListFragment)
        }
        return binding.root
    }


}