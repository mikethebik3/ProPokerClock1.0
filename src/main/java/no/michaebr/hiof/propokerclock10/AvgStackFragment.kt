package no.michaebr.hiof.propokerclock10

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class AvgStackFragment : Fragment() {

    var mbuttonTilbake: Button? = null

    companion object {
        fun newInstance() = AvgStackFragment()
    }

    private lateinit var viewModel: AvgStackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        val root = inflater.inflate(R.layout.fragment_avg_stack, container, false)

        mbuttonTilbake = root.findViewById(R.id.button_tilbake)

        mbuttonTilbake?.setOnClickListener {
            findNavController().navigate(R.id.action_avgStackFragment_to_mainFragment33)

        }
      return  inflater.inflate(R.layout.fragment_avg_stack, container, false)
    }






    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AvgStackViewModel::class.java)
        // TODO: Use the ViewModel
    }

}