package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetail : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentShoeDetailBinding

    private lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        binding.newShoeCancelButton.setOnClickListener {
            binding.newShoeNameInput.text.clear()
            binding.newShoeCompanyInput.text.clear()
            binding.newShoeSizeInput.text.clear()
            binding.newShoeDescriptionInput.text.clear()

            it.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }

        binding.newShoeSaveButton.setOnClickListener {
            //  get values from UI
            val name = binding.newShoeNameInput.text.toString()
            val company = binding.newShoeCompanyInput.text.toString()
            val size: Double = binding.newShoeSizeInput.text.toString().toDouble()
            val description = binding.newShoeDescriptionInput.toString()
            //  Create new entry in the viewModel
            viewModel.newShoeEntry(name, size, company, description)
            //  Create toast to let user know of successful save
            Toast.makeText(context, "SAVED!!", Toast.LENGTH_LONG).show()
        }

        //  Create shared viewModel
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeDetail.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeDetail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}