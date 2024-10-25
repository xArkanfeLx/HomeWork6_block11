package com.example.imageview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {

    private lateinit var imgIV:ImageView
    private lateinit var nextBTN:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nowImage = 0;
        val images = listOf(R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5)

        imgIV = findViewById(R.id.imgIV)
        nextBTN = findViewById(R.id.nextBTN)

        nextBTN.setOnClickListener{
            if(nowImage<images.size) imgIV.setImageResource(images[nowImage++])
            else {
                intent = Intent(this,FinalActivity::class.java)
                finishAffinity()
                startActivity(intent)
            }
        }
    }
}