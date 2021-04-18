package com.curlybraces.shoppinglistm.ui.shoppinglist

import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList

interface AddDialogListListener {
    fun onAddListButtonClicked(list: ShoppingList)
}