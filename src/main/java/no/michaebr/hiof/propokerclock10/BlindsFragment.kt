package no.michaebr.hiof.propokerclock10

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import no.michaebr.hiof.propokerclock10.databinding.FragmentBlindsBinding
import no.michaebr.hiof.propokerclock10.databinding.FragmentLoginBinding
import no.michaebr.hiof.propokerclock10.ui.login.LoginViewModel
import no.michaebr.hiof.propokerclock10.ui.login.LoginViewModelFactory


class BlindsFragment : Fragment() {
    private var _binding: FragmentBlindsBinding? = null


    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlindsBinding.inflate(inflater, container, false)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        binding.smallblind1.setText(sharedPref?.getInt(getString(R.string.small_blind_1), 200).toString())
        binding.smallblind2.setText(sharedPref?.getInt(getString(R.string.small_blind_2), 400).toString())
        binding.smallblind3.setText(sharedPref?.getInt(getString(R.string.small_blind_3), 800).toString())
        binding.smallblind4.setText(sharedPref?.getInt(getString(R.string.small_blind_4), 1600).toString())
        binding.smallblind5.setText(sharedPref?.getInt(getString(R.string.small_blind_5), 3200).toString())
        binding.smallblind6.setText(sharedPref?.getInt(getString(R.string.small_blind_6), 6400).toString())
        binding.bigblind1.setText(sharedPref?.getInt(getString(R.string.big_blind_1), 400).toString())
        binding.bigblind2.setText(sharedPref?.getInt(getString(R.string.big_blind_2), 800).toString())
        binding.bigblind3.setText(sharedPref?.getInt(getString(R.string.big_blind_3), 1600).toString())
        binding.bigblind4.setText(sharedPref?.getInt(getString(R.string.big_blind_4), 3200).toString())
        binding.bigblind5.setText(sharedPref?.getInt(getString(R.string.big_blind_5), 6400).toString())
        binding.bigblind6.setText(sharedPref?.getInt(getString(R.string.big_blind_6), 12800).toString())

        binding.buttonLagre.setOnClickListener {
            sharedPref?.edit {
                putInt(getString(R.string.small_blind_1), binding.smallblind1.text.toString().toInt())
                apply()
                putInt(getString(R.string.small_blind_2), binding.smallblind2.text.toString().toInt())
                apply()
                putInt(getString(R.string.small_blind_3), binding.smallblind3.text.toString().toInt())
                apply()
                putInt(getString(R.string.small_blind_4), binding.smallblind4.text.toString().toInt())
                apply()
                putInt(getString(R.string.small_blind_5), binding.smallblind5.text.toString().toInt())
                apply()
                putInt(getString(R.string.small_blind_6), binding.smallblind6.text.toString().toInt())
                apply()
                putInt(getString(R.string.big_blind_1), binding.bigblind1.text.toString().toInt())
                apply()
                putInt(getString(R.string.big_blind_2), binding.bigblind2.text.toString().toInt())
                apply()
                putInt(getString(R.string.big_blind_3), binding.bigblind3.text.toString().toInt())
                apply()
                putInt(getString(R.string.big_blind_4), binding.bigblind4.text.toString().toInt())
                apply()
                putInt(getString(R.string.big_blind_5), binding.bigblind5.text.toString().toInt())
                apply()
                putInt(getString(R.string.big_blind_6), binding.bigblind6.text.toString().toInt())
                apply()
            }
        }

        return binding.root
    }

}