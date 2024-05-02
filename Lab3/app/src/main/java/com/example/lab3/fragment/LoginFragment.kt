    package com.example.lab3.fragment

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Button
    import androidx.fragment.app.Fragment
    import com.example.lab3.R

    class LoginFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_login, container, false)
            val nextButton: Button = view.findViewById(R.id.next_menu)
            nextButton.setOnClickListener {
                val fragment = MenuFragment()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragment_view, fragment)?.commit()
            }
            return view
        }
    }