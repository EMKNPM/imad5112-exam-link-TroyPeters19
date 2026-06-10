package com.example.imad_exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Troy Peters
// ST10533034

class MainActivity : AppCompatActivity() {

    //Declarations
    private lateinit var btnMain: Button
    private lateinit var btnExit: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Typecasting
        btnMain = findViewById(R.id.btnMain)
        btnExit = findViewById(R.id.btnExit)

        // This will take the user to the next screen
        btnMain.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
        }

        // This will exit the user out of the app
        btnExit.setOnClickListener {
            finishAffinity()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}