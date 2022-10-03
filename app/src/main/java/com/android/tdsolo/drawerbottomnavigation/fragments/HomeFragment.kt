package com.android.tdsolo.drawerbottomnavigation.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.android.tdsolo.drawerbottomnavigation.MainActivity

import com.android.tdsolo.drawerwithbottomnavigation.R
import com.android.tdsolo.drawerwithbottomnavigation.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener { //OnClickListener

    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController() //Initialising navController

        //Initialising button click event listener
        binding.homeNextFragBtn.setOnClickListener(this)
        binding.homeCloseAppBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) { //When click occurs this function is triggered
        when(v?.id) { //Check for the id of the view i which click event happened
            R.id.home_next_frag_btn -> goToNextFragment()
            R.id.home_close_app_btn -> closeApp()
        }
    }

    private fun goToNextFragment() {
        val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment() //if needed pass values to frag here NB: add that arguments to nav_graph also
        navController.navigate(action) //navigation
    }

    private fun closeApp() {
        (activity as MainActivity).exitApp()
    }

}
