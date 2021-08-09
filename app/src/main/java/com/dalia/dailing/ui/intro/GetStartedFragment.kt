package com.dalia.dailing.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.dalia.dailing.R
import com.dalia.dailing.databinding.FragmentGetStartedBinding
import com.dalia.dailing.util.safeNavigate
import com.dalia.presentation.viewmodels.GetStartedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [GetStartedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GetStartedFragment : Fragment() {

    private val TAG = GetStartedFragment::class.java.canonicalName

    private val viewModel: GetStartedViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding
                = DataBindingUtil.inflate<FragmentGetStartedBinding>(
            inflater, R.layout.fragment_get_started, container, false)


        binding.getStartedButton.setOnClickListener { view ->
            viewModel.showOnboarding.observe(viewLifecycleOwner, Observer<Boolean>{
                if(it == true){
                    viewModel.disableOnboarding()
                    view.findNavController().safeNavigate(GetStartedFragmentDirections.actionGetStartedFragmentToOnboardingFragment())
                }else{
                    view.findNavController().safeNavigate(GetStartedFragmentDirections.actionGetStartedFragmentToSignUpFragment())
                }
            })
        }
        binding.alreadyHaveAnAccountBtn.setOnClickListener { view ->
            view.findNavController().safeNavigate(GetStartedFragmentDirections.actionGetStartedFragmentToLoginFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    companion object
}