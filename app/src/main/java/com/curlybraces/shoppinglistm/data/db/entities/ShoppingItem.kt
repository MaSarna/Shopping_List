package com.curlybraces.shoppinglistm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int,
    @ColumnInfo(name = "item_Timestamp")
    var itemTimestamp: Long,
    @ColumnInfo(name = "shopping_List_Id")
    var shoppingListId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}