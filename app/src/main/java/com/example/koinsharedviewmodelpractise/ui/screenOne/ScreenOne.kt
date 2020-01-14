package com.example.koinsharedviewmodelpractise.ui.screenOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.koinsharedviewmodelpractise.R
import com.example.koinsharedviewmodelpractise.databinding.ScreenOneFragmentBinding

class ScreenOne : Fragment() {

    //layout binding variable
    private lateinit var binding: ScreenOneFragmentBinding

    //Lazily Initialize viewModel using Koin
    private val viewModel: ScreenOneViewModel by /*viewModel()*/ lazy {
        activity?.run {
            ViewModelProviders.of(this).get(ScreenOneViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate Layout
        binding = ScreenOneFragmentBinding.inflate(inflater)

        //Set lifecycle owner
//        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Bind xml viewmodel to fragment's viewmodel
        binding.viewModel = this.viewModel

        //Observe 'gotoNextScreen' variable, if data changes to true, move to next screen
        viewModel.gotoNextScreen.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_screenOne_to_screenTwoFragment)
                viewModel.gotoNextScreenComplete()
            }
        })
    }

}
