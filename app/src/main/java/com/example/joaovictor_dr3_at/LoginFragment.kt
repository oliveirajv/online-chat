package com.example.joaovictor_dr3_at

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    //LoginFragment.
    private lateinit var editTextUserInputEmail: EditText
    private lateinit var editTextUserInputPassword: EditText
    private lateinit var buttonLogin: Button
    //Firebase.
    private lateinit var auth: FirebaseAuth
    //Facebook.
    private lateinit var callbackManager: CallbackManager
    private lateinit var buttonFacebookLogin: LoginButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        editTextUserInputEmail = view.findViewById(R.id.editTextUserInputEmail)
        editTextUserInputPassword = view.findViewById(R.id.editTextUserInputPassword)
        buttonLogin = view.findViewById(R.id.buttonGenericLogin)
        auth = Firebase.auth
        //Autenticação com Facebook.
        callbackManager = CallbackManager.Factory.create()
        buttonFacebookLogin.fragment = this
        buttonFacebookLogin.setPermissions("email", "public_profile")
        buttonFacebookLogin.registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                Log.d("TAG", "facebook:onSuccess:$loginResult")
//                handleFacebookAccessToken(loginResult.accessToken)
            }
            override fun onCancel() {
                Log.d("TAG", "facebook:onCancel")
            }
            override fun onError(error: FacebookException) {
                Log.d("TAG", "facebook:onError", error)
            }
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener {
            val userEmail = editTextUserInputEmail.text.toString()
            val userPassword = editTextUserInputPassword.text.toString()

            val task = auth.signInWithEmailAndPassword(userEmail, userPassword)

            task
                .addOnSuccessListener {
                findNavController().navigate(R.id.homeFragment)
            }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}