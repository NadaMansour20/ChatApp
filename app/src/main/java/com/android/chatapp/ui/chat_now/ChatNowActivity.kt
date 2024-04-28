package com.android.chatapp.ui.chat_now

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.Uses.Constent
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.database.get_message_Ref
import com.android.chatapp.databinding.ActivityChatNowBinding
import com.android.chatapp.model.Message
import com.android.chatapp.model.Room
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.Query

class ChatNowActivity : BaseActivity<ChatNowViewModel, ActivityChatNowBinding>(), Navigator {

    lateinit var room: Room
    var chat_adapter=ChatNowAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
        dataBinding.vmCN = viewModel

        room = intent.getParcelableExtra(Constent.constent)!!


        //set room that from home
        viewModel.room = room

        dataBinding.recyclerView.adapter=chat_adapter

        listen_message_update()


    }

    override fun get_layout_id(): Int {
        return R.layout.activity_chat_now
    }

    override fun get_view_model(): ChatNowViewModel {
        return ViewModelProvider(this).get(ChatNowViewModel::class.java)
    }

    //listen of real time update message
    fun listen_message_update(){
        get_message_Ref(room.id!!)
            // order message on adapter by date
            .orderBy("date",Query.Direction.ASCENDING)
            .addSnapshotListener{quary,exeption->
            if(exeption!=null){

            }
            else{
                val list_message_added= mutableListOf<Message>()
                for(dc in quary!!.documentChanges){
                    when (dc.type){
                        DocumentChange.Type.ADDED->{
                            val message=dc.document.toObject(Message::class.java)
                            list_message_added.add(message)
                        }

                        else -> {

                        }
                    }

                }

                chat_adapter.appendMessage(list_message_added)
                dataBinding.recyclerView.smoothScrollToPosition(chat_adapter.itemCount)
            }
        }

    }

}