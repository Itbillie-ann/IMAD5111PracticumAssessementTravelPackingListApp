# Travel Packing List App - IMAD5112 Practicum Assessment
This is a Android application built with Kotlin for the IMAD5112 Practicum assessment. 
The app acts as a travel packing list manager, allowing users to add items, categorise them, and view detailed lists based on specific criteria (such as quantities of 2 or more).


## Application Overview and Code Explanations
The application uses four parallel arrays declared in a companion object within MainActivity to store the packing list data:

- itemArray (String) - Stores the name of the item.
- categoryArray (String) - Stores the category (e.g., Clothing, Toiletries).
- quantityArray (Integer) - Stores the quantity. This is an Integer array to allow for mathematical filtering later.
- commentsArray (String) - Stores additional comments about the item.Using a companion object ensures the data persists and is accessible when navigating between the two screens.

### Screen One: MainActivity
This is the main screen of the application. It features four EditText fields for the user to input the Item Name, Category, Quantity, and Comments.

- Add to Packing List Button: Retrieves the input text, performs error handling, adds the valid data to the parallel arrays, clears the input fields, and shows a confirmation Toast.
- View Packing List Button: Uses an Intent to navigate the user to the second screen (PackListActivity).
- Exit App Button: Closes the application using finishAffinity().
  
## Main Screen Screenshot
- <img width="1279" height="651" alt="TRL#1" src="https://github.com/user-attachments/assets/ddec5054-a10e-49a5-be40-fb4a04139b76" />

### Screen Two: PackListActivity
This screen displays the data from the parallel arrays inside a TextView within a ScrollView.

- Display Full Packing List Button: Uses a for loop to iterate through the indices of the parallel arrays, appending each item's details to a StringBuilder, and displaying the complete formatted list.
- Display Items (Qty >= 2) Button: Uses a for loop with an if condition (qty >= 2) to filter the arrays, appending only items with a quantity of two or more to the StringBuilder.
- Back to Main Screen Button: Uses the finish() method to close the current activity and return to MainActivity.

## Packing List Screenshot
<img width="1279" height="614" alt="TRL#2" src="https://github.com/user-attachments/assets/ad3e6c87-bc79-4187-aec7-87b27539d1a1" />

### Error Handling
The app handles input errors to provide constructive feedback:

- If the user leaves the Item, Category, or Quantity fields blank, a Toast message appears asking them to fill in the required fields.
- If the user enters text instead of a number in the Quantity field, the toIntOrNull() 
method safely catches the error and displays a Toast message stating the quantity must be a valid number greater than 0.
- <img width="1270" height="615" alt="TRL#3" src="https://github.com/user-attachments/assets/ddfae3c0-0a1f-4ff7-be04-89525a60d9f4" />


### Technical Implementation
- Language: Kotlin
- IDE: Android Studio
- Data Structure: Parallel Arrays (ArrayList) to store item details.
- Navigation: Multi-screen navigation using Intent.
- Error Handling: Input validation using toIntOrNull() and isEmpty() checks with Toast feedback.
- Logging: Log.d() is used to track app events such as adding items and viewing lists in the Logcat.

## Author
**Alicia B Bukitu**
