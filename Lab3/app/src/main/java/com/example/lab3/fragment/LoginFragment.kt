package com.example.lab3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lab3.R
import com.example.lab3.database.DatabaseHelper
import com.example.lab3.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = DatabaseHelper(requireContext())

        binding.btnLogin.setOnClickListener {
            val loginUsername = binding.loginEmail.text.toString()
            val loginPassword = binding.loginPassword.text.toString()

            loginDatabase(loginUsername, loginPassword)
        }

        binding.nextSignUp.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, SignUpFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun loginDatabase(username: String, password: String) {
        val userExists = databaseHelper.readUser(username, password)
        if (userExists) {
            Toast.makeText(activity, "Login Successful", Toast.LENGTH_SHORT).show()
            // Navigate to MenuFragment and pass the password
            val menuFragment = MenuFragment()
            val bundle = Bundle()
            bundle.putString("password", password)
            menuFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, menuFragment)
                .addToBackStack(null)
                .commit()
        } else {
            Toast.makeText(activity, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}