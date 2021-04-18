package com.curlybraces.shoppinglistm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_list")
class ShoppingList(
    @ColumnInfo(name = "shopping_list_name")
    var shoppingListName: String,

    @ColumnInfo(name = "shopping_list_timestamp")
    var shoppingListTimestamp: Long,

    @ColumnInfo(name = "is_archived")
    var isArchived: Boolean
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}