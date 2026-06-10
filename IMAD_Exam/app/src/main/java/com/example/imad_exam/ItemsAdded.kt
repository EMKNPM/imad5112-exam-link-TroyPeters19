package com.example.imad_exam

data class ItemsAdded(

    //Store the name of the item
    val itemName : String,

    //Stores the category(eg. Food,shelter or Safety)
    var edtItemCategory: String = "",

    //Stores the quantity of the item
    var numItemQuantity: Int = 0,

    //Stores the comment/note of the item
    var edtItemComment: String = "",

    //Tracks whether the user has entered data for the selected item
    var dataCaptured: Boolean = false
)
