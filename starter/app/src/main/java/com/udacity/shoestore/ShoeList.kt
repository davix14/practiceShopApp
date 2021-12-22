package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)

        //  save view in var to edit before adding to activity
        var item1: View = getLayoutInflater().inflate(R.layout.shoelist_item_layout, null)
        var image1: ImageView = item1.findViewById<ImageView>(R.id.shoeListItem_Image)
        image1.setImageResource(R.drawable.shoe1)

//        binding.shoeListLinearLayoutV.addView()
        binding.shoeListLinearLayoutV.addView(item1)
        binding.shoeListLinearLayoutV.addView(getLayoutInflater().inflate(R.layout.shoelist_item_layout, null))
        binding.shoeListLinearLayoutV.addView(getLayoutInflater().inflate(R.layout.shoelist_item_layout, null))
        binding.shoeListLinearLayoutV.addView(getLayoutInflater().inflate(R.layout.shoelist_item_layout, null))

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