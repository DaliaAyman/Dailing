package com.dalia.dailing.ui.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.dalia.dailing.R
import kotlinx.android.synthetic.main.item_onboarding_slide_container.view.*

class OnboardingSlideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(onboardingSlide: OnboardingSlide) = with(itemView){
        onboarding_titleTextView.text = onboardingSlide.title
//        onboarding_imageView.setImageResource(onboardingSlide.icon)
        onboardingSlide.iconMinFrame?.let {
            onboarding_lottieAnimationView.setMinFrame(it)
        }
        onboardingSlide.iconMaxFrame?.let {
            onboarding_lottieAnimationView.setMaxFrame(it)
        }
        onboarding_lottieAnimationView.setAnimation(onboardingSlide.icon)
//        onboarding_lottieAnimationView.playAnimation()
    }

    companion object {
        fun create(parent: ViewGroup): OnboardingSlideViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_onboarding_slide_container, parent, false)
            return OnboardingSlideViewHolder(view)
        }
    }
}