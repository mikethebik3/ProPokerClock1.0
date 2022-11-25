package no.michaebr.hiof.propokerclock10.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import no.michaebr.hiof.propokerclock10.databinding.FragmentLoginBinding

import no.michaebr.hiof.propokerclock10.R

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_mainFragment3)

        }
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registrationFragment)
        }

        binding.button6.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_avgStackFragment2)
        }


    }
}