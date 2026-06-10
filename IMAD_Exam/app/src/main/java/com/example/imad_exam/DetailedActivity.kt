package com.example.imad_exam

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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
    private lateinit var btnBack: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}