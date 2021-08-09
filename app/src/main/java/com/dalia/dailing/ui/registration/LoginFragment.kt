package com.dalia.dailing.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.dalia.dailing.R
import com.dalia.dailing.databinding.FragmentLoginBinding
import com.dalia.dailing.ui.registration.LoginFragmentDirections
import com.dalia.dailing.util.Utils.setMessageWithClickableLink
import com.dalia.dailing.util.safeNavigate
import com.dalia.presentation.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding
                = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false)

        binding.signupTextInLoginPage.setMessageWithClickableLink(
            Pair("Sign Up", View.OnClickListener {
                findNavController().safeNavigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
            })
        )

        binding.loginButton.setOnClickListener {
            viewModel.loggedInSuccessful()
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToContainerHomeFragment())
        }

//        viewModel.isLoggedIn.observe(viewLifecycleOwner, Observer {
//            if (it == true){
//                view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
//            }else{
//                view?.findNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToGetStartedFragment())
//            }
//        })

        return binding.root
    }

}