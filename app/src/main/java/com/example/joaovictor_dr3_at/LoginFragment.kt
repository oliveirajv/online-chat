package com.example.joaovictor_dr3_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    private lateinit var editTextUserInputEmail: EditText
    private lateinit var editTextUserInputPassword: EditText
    private lateinit var buttonLogin: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        editTextUserInputEmail = view.findViewById(R.id.editTextUserInputEmail)
        editTextUserInputPassword = view.findViewById(R.id.editTextUserInputPassword)
        buttonLogin = view.findViewById(R.id.buttonLogin)
        auth = Firebase.auth
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentUser = auth.currentUser

        if (currentUser == null){
//            findNavController
        }
    }


}