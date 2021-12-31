package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentShoeListBinding

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
//        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

        arrayListOf<View>()

        //  observe shoes liveData for list of shoes
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                //  create new view from shoelist_Item layout
                val item: View = getLayoutInflater().inflate(R.layout.shoelist_item_layout, null)
                //  set name
                val name = item.findViewById<TextView>(R.id.shoeItem_shoeName_Text)
                name.setText(shoe.name)
                //  set company
                val company = item.findViewById<TextView>(R.id.shoeItem_company_Text)
                company.setText(shoe.company)
                //  set image
                val image = item.findViewById<ImageView>(R.id.shoeListItem_Image)
                if (shoe.images.isNotEmpty()) {
                    image.setImageResource(shoe.images.get(0))
                }
                //  add to linear layout view
                binding.shoeListLinearLayoutV.addView(item)
            }
        })

        //  adding onClickListener for floating action button to navigate to the detail
        binding.shoeDetailNewFAB.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }

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
         * @return A new instance of fragment ShoeList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}