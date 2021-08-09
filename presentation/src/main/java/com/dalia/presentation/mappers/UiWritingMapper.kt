package com.dalia.presentation.mappers

import com.dalia.domain.model.common.Writing
import com.dalia.presentation.models.UIWriting
import javax.inject.Inject

class UiWritingMapper @Inject constructor(): UiMapper<Writing, UIWriting>{

    override fun mapToView(input: Writing): UIWriting {
        return UIWriting(
                id = input.id,
                text = input.text,
                photo = input.image.getSmallestAvailablePhoto()
        )
    }
}