package com.curlybraces.shoppinglistm.data.repositories

import com.curlybraces.shoppinglistm.data.db.ShoppingDatabase
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun insertShoppingList(shoppingList: ShoppingList) = db.getShoppingDao().insertShoppingList(shoppingList)

    suspend fun updateShoppingList(shoppingList: ShoppingList) = db.getShoppingDao().updateShoppingList(shoppingList)

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}