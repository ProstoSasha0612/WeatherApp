package com.projectapp.weatherapp.presentation.view.weekforecastscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.projectapp.weatherapp.presentation.ui.composeelements.weekforecast.WeekForecastScreen
import com.projectapp.weatherapp.presentation.view.mainscreen.MainViewModel

class WeekForecastFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            Log.d("MYTAG", "Week forecast fragment opened")
            setContent {
                MaterialTheme {
                    WeekForecastScreen(viewModel = viewModel, onBackClick = { onBackCLick() })
                }
            }
        }
    }

    private fun onBackCLick() {
        findNavController().popBackStack()
    }

    companion object {
        fun newInstance() = WeekForecastFragment()
    }
}