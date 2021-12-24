package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    //  fill arrayList with objects of SHOE model
    val shoes: LiveData<ArrayList<Shoe>>
        get() {
            return shoes
        }

    private lateinit var _shoes: MutableLiveData<ArrayList<Shoe>>

    val shoe1: Shoe = Shoe(
        "David", 9.5,
        "Nike", "Great shoes for anything",
        mutableListOf(R.drawable.shoe1)
    )
    val shoe2: Shoe = Shoe(
        "Joe", 8.5, "Adidas", "Great shoes for anything",
        mutableListOf(R.drawable.shoe2)
    )
    val shoe3: Shoe = Shoe(
        "Green", 10.0, "New Balance", "Great shoes for anything",
        mutableListOf(R.drawable.shoe3)
    )
    val shoe4: Shoe = Shoe(
        "Blook", 7.0, "O N", "Great shoes for anything",
        mutableListOf(R.drawable.shoe4)
    )
    val shoe5: Shoe = Shoe(
        "Hared", 12.5, "Birkenstock", "Great shoes for anything",
        mutableListOf(R.drawable.shoe5)
    )
    val shoe6: Shoe = Shoe(
        "SPICE", 10.5, "Melange", "Great shoes for anything",
        mutableListOf(R.drawable.shoe6)
    )
    val shoe7: Shoe = Shoe(
        "JakInBox", 6.5, "Smalleez", "Great shoes for anything",
        mutableListOf(R.drawable.shoe7)
    )

    init {
        _shoes.value =
            arrayListOf<Shoe>(
                shoe1,
                shoe2,
                shoe3,
                shoe4,
                shoe5,
                shoe6,
                shoe7
            )


    }


}