package com.android.chatapp.ui.add_chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.chatapp.R
import com.android.chatapp.Uses.OnItemListener
import com.android.chatapp.databinding.ChatItemBinding
import com.android.chatapp.model.Room

class AddChatAdapter(var list_item: List<Room?>?) : Adapter<AddChatAdapter.ChatViewHolder>() {

    var On_item_listener: OnItemListener? = null


    class ChatViewHolder(var viewBinding: ChatItemBinding) : ViewHolder(viewBinding.root) {
        fun Binding(room: Room) {
            viewBinding.item = room
            viewBinding.invalidateAll()

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        val viewBinding: ChatItemBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.chat_item,
                parent,
                false
            )

        return ChatViewHolder((viewBinding))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

        holder.Binding(list_item!![position]!!)

        if (On_item_listener != null) {

            //holder.itemView.setOnClickListener()

            holder.viewBinding.root.setOnClickListener {
                On_item_listener?.On_item_click(position, list_item!![position]!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return list_item?.size ?: 0
    }

    fun chande_data(room_item: List<Room>) {
        list_item = room_item
        notifyDataSetChanged()
    }


}