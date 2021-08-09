package com.dalia.dailing.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.dalia.dailing.R
import com.dalia.dailing.databinding.FragmentOnboardingBinding
import com.dalia.dailing.util.safeNavigate

class OnboardingFragment : Fragment() {

    private var binding: FragmentOnboardingBinding? = null

    private lateinit var onboardingSlideAdapter: OnboardingSlideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onboardingSlideAdapter = OnboardingSlideAdapter(
            listOf(
                OnboardingSlide(
                    resources.getString(R.string.first_slide_title),
                    R.raw.around_the_clock
                ),
                OnboardingSlide(
                    resources.getString(R.string.second_slide_title),
                    R.raw.overwhelmed
                ),
                OnboardingSlide(
                    resources.getString(R.string.third_slide_title),
                        R.raw.dailing,
                        iconMinFrame = 25,
                        iconMaxFrame = 107
                )
            )
        )
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.onboardingViewPager?.adapter = onboardingSlideAdapter

        binding?.onboardingIndicator?.setViewPager(binding?.onboardingViewPager)

        binding?.onboardingViewPager?.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if(position == onboardingSlideAdapter.itemCount - 1){
                    showLastStepButtons()
                }else{
                    hideLastStepButtons()
                    binding?.nextButton?.setOnClickListener {
                        binding?.onboardingViewPager?.currentItem?.let {
                            binding?.onboardingViewPager?.setCurrentItem(it + 1, true)
                        }
                    }
                }
            }
        })

        binding?.startDailingButton?.setOnClickListener {
            findNavController().safeNavigate(OnboardingFragmentDirections.actionOnboardingFragmentToSignUpFragment())
        }

        binding?.skipButton?.setOnClickListener {
            findNavController().safeNavigate(OnboardingFragmentDirections.actionOnboardingFragmentToSignUpFragment())
        }
    }

    private fun showLastStepButtons() {
        val animationFadeIn = AnimationUtils.loadAnimation(requireActivity(), R.anim.nav_default_pop_enter_anim)
        binding?.startDailingButton?.animation = animationFadeIn

        binding?.nextButton?.visibility = View.INVISIBLE
        binding?.skipButton?.visibility = View.INVISIBLE
        binding?.startDailingButton?.visibility = View.VISIBLE
    }

    private fun hideLastStepButtons(){
        binding?.nextButton?.visibility = View.VISIBLE
        binding?.skipButton?.visibility = View.VISIBLE
        binding?.startDailingButton?.visibility = View.INVISIBLE
    }
}