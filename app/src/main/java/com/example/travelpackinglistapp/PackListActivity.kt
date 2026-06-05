package com.example.travelpackinglistapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PackListActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_list)

        // 1. Link views from XML
        val txtDisplayList = findViewById<TextView>(R.id.txtDisplayList)
        val btnShowAll = findViewById<Button>(R.id.btnShowAll)
        val btnShowFiltered = findViewById<Button>(R.id.btnShowFiltered)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // 2. DISPLAY PACKING LIST
        btnShowAll.setOnClickListener {
            // Error Handling: Check if the list is empty
            if (MainActivity.itemArray.isEmpty()) {
                Toast.makeText(this, "The packing list is empty!", Toast.LENGTH_SHORT).show()
                txtDisplayList.text = "No items added yet."
                return@setOnClickListener
            }

            // Logging requirement
            Log.d("PackingApp", "Displaying full list")

            val stringBuilder = StringBuilder()

            // LOOP through parallel arrays to build the text string
            for (i in MainActivity.itemArray.indices) {
                val name = MainActivity.itemArray[i]
                val cat = MainActivity.categoryArray[i]
                val qty = MainActivity.quantityArray[i]
                val comment = MainActivity.commentsArray[i]

                stringBuilder.append("Item: $name\n")
                stringBuilder.append("Category: $cat\n")
                stringBuilder.append("Quantity: $qty\n")
                stringBuilder.append("Comments: $comment\n")
                stringBuilder.append("-------------------------\n")
            }

            // Display the built string on screen
            txtDisplayList.text = stringBuilder.toString()
        }

        // 3. DISPLAY ITEMS WITH QUANTITY >= 2
        btnShowFiltered.setOnClickListener {
            if (MainActivity.itemArray.isEmpty()) {
                Toast.makeText(this, "The packing list is empty!", Toast.LENGTH_SHORT).show()
                txtDisplayList.text = "No items added yet."
                return@setOnClickListener
            }

            Log.d("PackingApp", "Displaying filtered list (Qty >= 2)")

            val stringBuilder = StringBuilder()
            var foundItems = false

            // LOOP through arrays and filter by quantity
            for (i in MainActivity.itemArray.indices) {
                val qty = MainActivity.quantityArray[i]

                // The core logic: check if quantity is 2 or more
                if (qty >= 2) {
                    val name = MainActivity.itemArray[i]
                    stringBuilder.append("Item: $name\n")
                    stringBuilder.append("Quantity: $qty\n")
                    stringBuilder.append("-------------------------\n")
                    foundItems = true
                }
            }

            // Error Handling / Feedback: What if no items have qty >= 2?
            if (!foundItems) {
                stringBuilder.append("No items found with a quantity of 2 or more.")
                Toast.makeText(this, "No items meet the criteria", Toast.LENGTH_SHORT).show()
            }

            txtDisplayList.text = stringBuilder.toString()
        }

        // 4. BACK TO MAIN SCREEN
        btnBack.setOnClickListener {
            Log.d("PackingApp", "Returning to Main Screen")
            finish() // Closes this screen and returns to the previous one
        }
    }
}