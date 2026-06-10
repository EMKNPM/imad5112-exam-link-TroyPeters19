package com.example.imad_exam

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {

    // Declarations
    private lateinit var spinner: Spinner
    private lateinit var edtCategory: EditText
    private lateinit var edtQuantity: EditText
    private lateinit var edtComment: EditText
    private lateinit var btnTotal: Button
    private lateinit var btnSave: Button
    private lateinit var btnBack: Button

    // A companion object is used so that both the MainScreen and DetailedActivity screens are able use the array directly
    companion object {
        val itemsArray = arrayOf(
            ItemsAdded("Tent"),
            ItemsAdded("Wors"),
            ItemsAdded("Flashlight"),
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)

        // Typecasting
        spinner = findViewById(R.id.spinner)
        edtCategory = findViewById(R.id.edtCategory)
        edtQuantity = findViewById(R.id.edtQuantity)
        edtComment = findViewById(R.id.edtComment)
        btnTotal = findViewById(R.id.btnTotal)
        btnSave = findViewById(R.id.btnSave)
        btnBack = findViewById(R.id.btnBack)

        // The spinner will pull the list of items from the array
        val itemNames = itemsArray.map { it.itemName }

        // The adapter will place the item names into the spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemNames)

        // This will set the layout of the spinner dropdown when it is used
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // This connects the adapter to the spinner so the days appear in the dropdown
        spinner.adapter = adapter

        // When the Save Data button is clicked, it saves the selected item's entered data
        btnSave.setOnClickListener {
            saveData()
        }

        // When the Total Items button is clicked, it calculates the total number of items
        btnTotal.setOnClickListener {
            calculateTotal()
        }

        // When the Back to Base is clicked, it will go back to the main screen
        btnBack.setOnClickListener {

            // The button will only work if the user enters data for all items otherwise they will be asked to enter the data with an error message
            if (allDataEntered()) {
                val intent = Intent(this, MainScreenActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Please enter data for all items",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Padding is adjusted so the content does not overlap the navigation options.
        // Improves the layout of the app
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }







}