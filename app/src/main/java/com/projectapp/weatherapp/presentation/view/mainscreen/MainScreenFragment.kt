package com.projectapp.weatherapp.presentation.view.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.projectapp.weatherapp.presentation.ui.composeelements.MainScreen

class MainScreenFragment : Fragment() {

    private val viewModel: MainScreenViewModel by lazy { ViewModelProvider(this)[MainScreenViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    MainScreen()
                }
            }
        }
    }

    companion object {
        fun newInstance() = MainScreenFragment()
    }
}
