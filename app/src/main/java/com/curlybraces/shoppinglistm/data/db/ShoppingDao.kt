package com.curlybraces.shoppinglistm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList

@Dao
interface ShoppingDao {

    @Insert
    suspend fun insertShoppingList(shoppingList: ShoppingList)

    @Update
    suspend fun updateShoppingList(shoppingList: ShoppingList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_list WHERE is_archived IS 0 ORDER BY shopping_list_timestamp DESC")
    fun getCurrentShoppingList(): LiveData<List<ShoppingList>>

    @Query("SELECT * FROM shopping_list WHERE is_archived IS 1 ORDER BY shopping_list_timestamp DESC")
    fun getArchivedShoppingList(): LiveData<List<ShoppingList>>

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}