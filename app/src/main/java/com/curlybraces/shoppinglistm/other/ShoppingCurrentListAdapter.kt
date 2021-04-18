package com.curlybraces.shoppinglistm.other

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.curlybraces.shoppinglistm.R
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingItem
import com.curlybraces.shoppinglistm.data.db.entities.ShoppingList
import com.curlybraces.shoppinglistm.ui.shoppinglist.ShoppingActivity
import com.curlybraces.shoppinglistm.ui.shoppinglist.ShoppingListActivity
import com.curlybraces.shoppinglistm.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*
import kotlinx.android.synthetic.main.shopping_list.view.*
import java.security.AccessController.getContext
import java.util.*

class ShoppingCurrentListAdapter(
    var currLists: List<ShoppingList>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingCurrentListAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currLists.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = currLists[position]

        holder.itemView.tvListName.text = curShoppingItem.shoppingListName
        holder.itemView.tvListDate.text = Calendar.DATE.toString()

        holder.itemView.ivForward.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ShoppingActivity::class.java)
            context.startActivity(intent)
        }


        holder.itemView.ivArchive.setOnClickListener {
        }
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}