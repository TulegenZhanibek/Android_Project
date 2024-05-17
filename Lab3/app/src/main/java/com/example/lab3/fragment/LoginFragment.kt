package com.example.lab3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lab3.R
//import dagger.hilt.android.AndroidEntryPoint
//
//
//@AndroidEntryPoint
class LoginFragment : Fragment() {
//    private val viewModel: LoginViewModel by viewModels()
//
//    private lateinit var email: EditText
//    private lateinit var password: EditText
//    private lateinit var signUp: TextView
//    private lateinit var login: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val nextButton: Button = view.findViewById(R.id.next_menu)
        nextButton.setOnClickListener {
            val fragment = MenuFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        email = view.findViewById(R.id.sign_in_email)
//        password = view.findViewById(R.id.sign_in_password)
//        signUp = view.findViewById(R.id.next_sign_out)
//        login = view.findViewById(R.id.next_menu)
//
//        requireView().findViewById<View>(R.id.parent).setOnClickListener {
//            hideKeyboard()
//        }
//
//        signUp.setOnClickListener {
//            startActivity(Intent(requireContext(), SignUpFragment::class.java))
//        }
//
//        login.setOnClickListener {
//            if (requireActivity().checkStateSoftKeyBoard()) {
//                hideKeyboard()
//            }
//            setUpViewModel()
//        }
//    }
//
//    private fun setUpViewModel() {
//        val email = email.text.toString()
//        val password = password.text.toString()
//
//        viewModel.getUserLoginDataStatus(email, password)
//
//        viewModel.getUserLoginDataStatus.observe(viewLifecycleOwner, { result ->
//            when (result.status) {
//                Status.SUCCESS -> {
//                    debugPrintln("it.messageSuccess = ${result.message}")
//                    debugPrintln("it.data = ${result.data}")
//                    if (result.data != null) {
//                        runBlocking {
//                            PrefUtil(requireContext()).saveLastLoginID(result.data.id)
//                            PrefUtil(requireContext()).saveLastLogin("Yes")
//                        }
//                        // startActivity(Intent(requireContext(), DashboardActivity::class.java))
//                        // requireActivity().finish()
//                        // Предполагаю, что вам нужно перейти к другому фрагменту после успешного входа, заместо startActivity и finish.
//                        // findNavController().navigate(R.id.navigation)
//                    } else {
//                        Snackbar.make(requireView(), "User does not exist in database.", Snackbar.LENGTH_LONG).show()
//                    }
//                }
//                Status.ERROR -> {
//                    debugPrintln("it.message = ${result.message}")
//                    Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG).show()
//                }
//                else -> {}
//            }
//        })
//    }
//
//    private fun setBackgroundForLL1() {
//        val gradientDrawable = GradientDrawable(
//            GradientDrawable.Orientation.LEFT_RIGHT,
//            intArrayOf(
//                Color.parseColor("#000000"),
//                Color.parseColor("#ffffff")
//            ),
//        )
//        gradientDrawable.cornerRadius = 0f
//
//        //TODO: Implement your view background setting logic
//    }
}
