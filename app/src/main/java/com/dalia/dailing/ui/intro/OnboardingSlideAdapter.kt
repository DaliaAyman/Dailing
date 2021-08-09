package com.dalia.dailing.ui.intro

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OnboardingSlideAdapter(private val onboardingSlides: List<OnboardingSlide>)
    : RecyclerView.Adapter<OnboardingSlideViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingSlideViewHolder {
        return OnboardingSlideViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: OnboardingSlideViewHolder, position: Int) {
        holder.bind(onboardingSlides[position])
    }

    override fun getItemCount(): Int = onboardingSlides.size
}