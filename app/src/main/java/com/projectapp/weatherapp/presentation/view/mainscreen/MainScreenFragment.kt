package com.projectapp.weatherapp.presentation.view.mainscreen

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
import com.projectapp.weatherapp.presentation.ui.composeelements.MainScreen
import com.projectapp.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.projectapp.wetherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d("MYTAG", "viewmodel is =$viewModel")
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WeatherAppTheme() {
                    MainScreen(viewModel, on7dayClick = { navigateToWeekForecastScreen() })
                }
            }
        }
    }

    private fun navigateToWeekForecastScreen() {
        val navController = findNavController()

        Log.d("MYTAG","navController is =$navController")
        navController.navigate(R.id.action_mainScreenFragment_to_weekForecastFragment)
    }

    companion object {
        fun newInstance() = MainScreenFragment()
    }
}
