package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ShoeView
import kotlinx.android.synthetic.main.activity_main.*


class shoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    val viewModel by viewModels<ShoeListViewModel>({requireActivity()})
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty())
                createShoes(it);
        })
        binding.lifecycleOwner= viewLifecycleOwner
        binding.floatingActionButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_shoeListFragment_to_detailsFragment)
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)}

    private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.shoeList
            shoes.forEach { shoe ->

                val shoeView = ShoeView(context)
                shoeView.loadShoe(shoe)
                shoeContainer.addView(shoeView)
            }}}
}
