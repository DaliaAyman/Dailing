package com.dalia.dailing.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.dalia.dailing.R
import com.dalia.dailing.databinding.FragmentSignUpBinding
import com.dalia.dailing.util.Utils.setMessageWithClickableLink
import com.dalia.dailing.util.safeNavigate

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding
                = DataBindingUtil.inflate<FragmentSignUpBinding>(
            inflater, R.layout.fragment_sign_up, container, false)


//        binding.checkBoxTextView.setMessageWithClickableLink(
//            Pair("Conditions", View.OnClickListener {
//                Toast.makeText(context, "Conditions Clicked", Toast.LENGTH_SHORT).show()
//            }),
//            Pair("Privacy policy", View.OnClickListener {
//                Toast.makeText(context, "Privacy policy Clicked", Toast.LENGTH_SHORT).show()
//            }))

        binding.loginTextInSignUpPage.setMessageWithClickableLink(
            Pair("Login", View.OnClickListener {
                findNavController().safeNavigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
            })
        )


        return binding.root
    }

}