package com.example.qasim.whatsappclone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qasim.whatsappclone.R;
import com.example.qasim.whatsappclone.model.Message;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageView> {
    private ArrayList<Message> messages;
    private Context context;

    public MessageAdapter(ArrayList<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(i, viewGroup, false);
        return new MessageView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageView messageView, int i) {
        Message message = messages.get(i);
        messageView.messageText.setText(message.getText());
        messageView.dateText.setText(message.getFormattedDate());
    }

    @Override
    public int getItemCount() {
        if (messages == null)
            return 0;
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        if (message.isFromMe())
            return R.layout.message_right;
        else
            return R.layout.message_left;
    }

    public class MessageView extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView dateText;

        public MessageView(@NonNull View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.textview_message);
            dateText = itemView.findViewById(R.id.textview_time);
        }
    }
}
