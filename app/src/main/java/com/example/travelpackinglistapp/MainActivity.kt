package com.example.travelpackinglistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        val itemArray = ArrayList<String>()
        val categoryArray = ArrayList<String>()
        val quantityArray = ArrayList<Int>()
        val commentsArray = ArrayList<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.TravelMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // EditTexts
        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComments = findViewById<EditText>(R.id.edtComments)

        // Buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Add Item
        btnAdd.setOnClickListener {

            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quantityText = edtQuantity.text.toString()
            val comments = edtComments.text.toString()

            if (
                item.isEmpty() ||
                category.isEmpty() ||
                quantityText.isEmpty() ||
                comments.isEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {

                val quantity = quantityText.toInt()

                itemArray.add(item)
                categoryArray.add(category)
                quantityArray.add(quantity)
                commentsArray.add(comments)

                Toast.makeText(this, "Item Added Successfully", Toast.LENGTH_SHORT).show()

                // Clear inputs
                edtItem.text.clear()
                edtCategory.text.clear()
                edtQuantity.text.clear()
                edtComments.text.clear()
            }
        }
        // Go to Screen 2
        btnView.setOnClickListener {
            val intent = Intent(this, PackListActivity::class.java)
            startActivity(intent)
        }
        // Exit App
        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}