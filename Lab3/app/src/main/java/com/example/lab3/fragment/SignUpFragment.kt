package com.example.lab3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lab3.R
import com.example.lab3.database.DatabaseHelper
import com.example.lab3.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = DatabaseHelper(requireContext())

        binding.btnSignUp.setOnClickListener {
            val signupUsername = binding.signUpEmail.text.toString()
            val signupPassword = binding.signUpPassword.text.toString()
            signupDatabase(signupUsername, signupPassword)
        }

        binding.nextLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, LoginFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun signupDatabase(username: String, password: String) {
        val insertedRowId = databaseHelper.insertUser(username, password)
        if (insertedRowId != -1L) {
            Toast.makeText(activity, "Signup Successful", Toast.LENGTH_SHORT).show()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, LoginFragment())
                .addToBackStack(null)
                .commit()
        } else {
            Toast.makeText(activity, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}