package com.curlybraces.shoppinglistm.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.curlybraces.shoppinglistm.R
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*
import kotlinx.android.synthetic.main.dialog_add_shopping_list.*

class AddShoppingListDialog(context: Context, var addDialogListener: AddDialogListListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_list)

        tvListAdd.setOnClickListener {
            val name = etListName.text.toString()
            val timeStamp = System.currentTimeMillis()

            if (name.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val list = ShoppingList(name, timeStamp, false)
            addDialogListener.onAddListButtonClicked(list)
            dismiss()
        }

        tvListCancel.setOnClickListener {
            cancel()
        }
    }
}