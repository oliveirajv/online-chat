package com.example.joaovictor_dr3_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

//    private lateinit var auth: FirebaseAuth
    private  lateinit var buttonGoToChat: Button

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

//        val currentUser = auth.currentUser
//        if (currentUser == null){
//            findNavController().navigate(R.id.loginFragment)
//        }
    }
}
