package com.dalia.dailing.ui.intro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.dalia.dailing.R
import com.dalia.dailing.databinding.FragmentSplashBinding
import com.dalia.data.preferences.PrefsStoreImpl
import com.dalia.presentation.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by activityViewModels()

    private val handler = Handler(Looper.getMainLooper())
    private val runnable = Runnable {

        viewModel.isLoggedIn.observe(viewLifecycleOwner, Observer {
            if (it == true){
                view?.findNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToContainerHomeFragment())
            }else{
                view?.findNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToGetStartedFragment())
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Hide the status bar.
//        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

//        activity?.let { Utils.hideSystemUI(it) }

//        (activity as AppCompatActivity).let { Utils.fullScreen(it) }
//        activity?.window?.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FhLAG_FULLSCREEN);
//
//        //You must hide action bar when you hide status bar.
//        activity?.actionBar?.hide()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSplashBinding>(
            layoutInflater, R.layout.fragment_splash, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SplashFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplashFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }


}