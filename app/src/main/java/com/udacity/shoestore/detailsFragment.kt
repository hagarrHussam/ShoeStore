package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding


class detailsFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentDetailsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


}