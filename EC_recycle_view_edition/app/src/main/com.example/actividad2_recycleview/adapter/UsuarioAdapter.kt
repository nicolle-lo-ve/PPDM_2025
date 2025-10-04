package com.example.actividad2_recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class UsuarioAdapter(var items:ArrayList<Usuario>): RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)

    }

    override fun onBindViewHolder( holder: UsuarioViewHolder, position: Int) {
        val user = items[position]
        holder.bind(user,
            onDelete = { pos -> removeUser(pos) },
            onEditClick = { pos, updatedUser -> editUser(pos, updatedUser) }
        )
    }

    override fun getItemCount(): Int = items.size

    fun addUser(user:Usuario){
        items.add(user)
        notifyItemInserted(getItemCount() - 1)
    }

    fun removeUser(position:Int){
        if (position in items.indices) {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, getItemCount()-1)
        }
    }

    fun editUser(position: Int, updatedUser: Usuario) {
        if (position in items.indices) {
            items[position] = updatedUser
            notifyItemChanged(position)
        }
    }


}
