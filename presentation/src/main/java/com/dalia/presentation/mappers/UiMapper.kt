package com.dalia.presentation.mappers

interface UiMapper<E, V> {

  fun mapToView(input: E): V
}