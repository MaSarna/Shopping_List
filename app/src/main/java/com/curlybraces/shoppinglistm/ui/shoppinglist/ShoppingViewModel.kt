package com.curlybraces.shoppinglistm.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList
import com.curlybraces.shoppinglistm.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun insertShoppingList(shoppingList: ShoppingList) = CoroutineScope(Dispatchers.Main).launch {
        repository.insertShoppingList(shoppingList)
    }

    fun updateShoppingList(shoppingList: ShoppingList) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateShoppingList(shoppingList)
    }

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getCurrentShoppingList() = repository.getCurrentShoppingList()

    fun getArchivedShoppingList() = repository.getArchivedShoppingList()

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}