package com.android.chatapp.ui.chat_now

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.chatapp.R
import com.android.chatapp.Uses.DataUtils
import com.android.chatapp.databinding.MassageReceiveBinding
import com.android.chatapp.databinding.MassageSendBinding
import com.android.chatapp.model.Message

class ChatNowAdapter : RecyclerView.Adapter<ViewHolder>() {

    var list_item = mutableListOf<Message?>()


    var SENT = 1
    var RECEIVED = 2
    override fun getItemViewType(position: Int): Int {
        val message = list_item[position]
        if (message?.sender_id == DataUtils.use?.id) {
            return SENT
        } else return RECEIVED

    }

    class SentMessageViewHolder(var dataBindingSent: MassageSendBinding) :
        ViewHolder(dataBindingSent.root) {
        fun Binding(message: Message) {
            dataBindingSent.sentMessage = message
            dataBindingSent.invalidateAll()
        }
    }

    class ReceivedMessageViewHolder(var dataBindingSent: MassageReceiveBinding) :
        ViewHolder(dataBindingSent.root) {
        fun Binding(message: Message) {
            dataBindingSent.receiveMessage = message
            dataBindingSent.invalidateAll()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (RECEIVED == viewType) {
            val viewBinding: MassageReceiveBinding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.massage_receive, parent, false
                )
            return ReceivedMessageViewHolder(viewBinding)

        } else {
            val viewBinding: MassageSendBinding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.massage_receive, parent, false
                )
            return SentMessageViewHolder(viewBinding)

        }

    }

    override fun getItemCount(): Int {
        return list_item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (holder is ReceivedMessageViewHolder) {
            holder.Binding(list_item[position]!!)

        } else if (holder is SentMessageViewHolder) {
            holder.Binding(list_item[position]!!)

        }
    }
}