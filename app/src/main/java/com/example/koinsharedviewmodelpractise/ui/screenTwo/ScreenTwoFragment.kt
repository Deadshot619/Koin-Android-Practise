package com.example.koinsharedviewmodelpractise.ui.screenTwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.koinsharedviewmodelpractise.databinding.ScreenTwoFragmentBinding
import com.example.koinsharedviewmodelpractise.ui.screenOne.ScreenOneViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ScreenTwoFragment : Fragment() {

    //layout binding variable
    private lateinit var binding: ScreenTwoFragmentBinding

    //Lazily Initialize viewModel using Koin
    private val viewModel: ScreenOneViewModel by sharedViewModel()

    //The following method is used to define a sharedViewModel
    /*lazy {
        activity?.run {
            ViewModelProviders.of(this).get(ScreenOneViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }
*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate Layout
        binding = ScreenTwoFragmentBinding.inflate(inflater)

        //Set lifecycle owner
//        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.viewModel = this.viewModel

    }

}
