package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding
import java.util.zip.Inflater


class LoginFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        // Inflate the layout for this fragment
        binding.loginBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.signupBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        return binding.root
    }


}