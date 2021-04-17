package com.curlybraces.shoppinglistm.ui.shoppinglist

import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}