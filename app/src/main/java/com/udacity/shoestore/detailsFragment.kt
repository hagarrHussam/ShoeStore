package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_main.*


class detailsFragment : Fragment() {
    val viewModel by viewModels<ShoeListViewModel>({ requireActivity() })



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentDetailsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        // Inflate the layout for this fragment
        requireActivity().toolbar.setTitle("Add Shoe")
        binding.viewModel = viewModel
        binding.saveBtn.setOnClickListener {
            val shoe = viewModel.makeShoe()
            Toast.makeText(context, shoe.name, Toast.LENGTH_LONG).show()
            viewModel.addShoe(shoe)

            findNavController().navigateUp()
        }

        binding.CancelBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }


}