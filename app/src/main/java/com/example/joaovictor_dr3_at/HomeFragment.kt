package com.example.joaovictor_dr3_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

//    private lateinit var auth: FirebaseAuth
    private lateinit var buttonGoToChat: Button
    private lateinit var textViewApiWeatherTemperature: TextView
    private lateinit var textViewApiWeatherDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        buttonGoToChat = view.findViewById(R.id.buttonGoToChat)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonGoToChat.setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }

        textViewApiWeatherTemperature = view.findViewById(R.id.textViewApiWeatherTemperature)
        textViewApiWeatherDescription = view.findViewById(R.id.textViewApiWeatherDescription)
        textViewApiWeatherTemperature.text = Weather().temperature
    }

    private fun setUpViewModel(view: View) {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        viewModel.weather.observe(viewLifecycleOwner){
            if (it != null)
                showSnackBar(view, it.temperature)
        }
    }
}
