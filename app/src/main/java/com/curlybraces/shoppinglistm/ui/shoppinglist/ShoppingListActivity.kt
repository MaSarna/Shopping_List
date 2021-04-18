package com.curlybraces.shoppinglistm.ui.shoppinglist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.curlybraces.shoppinglistm.R
import com.curlybraces.shoppinglistm.data.db.ShoppingDatabase
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList
import com.curlybraces.shoppinglistm.data.repositories.ShoppingRepository
import com.curlybraces.shoppinglistm.other.ShoppingCurrentListAdapter
import com.curlybraces.shoppinglistm.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_current_list.*
import kotlinx.android.synthetic.main.activity_shopping.*
import kotlinx.android.synthetic.main.shopping_list.*


class ShoppingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_list)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingCurrentListAdapter(listOf(), viewModel)

        rvShoppingList.layoutManager = LinearLayoutManager(this)
        rvShoppingList.adapter = adapter

        viewModel.getCurrentShoppingList().observe(this, Observer {
            adapter.currLists = it
            adapter.notifyDataSetChanged()
        })



        fab_list.setOnClickListener {
            AddShoppingListDialog(this,
                object : AddDialogListListener {
                    override fun onAddListButtonClicked(list: ShoppingList) {
                        viewModel.insertShoppingList(list)
                    }
                }).show()
        }
    }
}