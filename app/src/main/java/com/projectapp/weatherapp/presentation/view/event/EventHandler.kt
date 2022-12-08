package com.projectapp.weatherapp.presentation.view.event

interface EventHandler<T> {
    fun obtainEvent(event: T)
}
