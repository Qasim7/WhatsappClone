package com.example.qasim.whatsappclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.qasim.whatsappclone.adapter.MessageAdapter;
import com.example.qasim.whatsappclone.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ChatWithPerson extends AppCompatActivity {
    private EditText editText;
    private RecyclerView recyclerView;
    private ArrayList<Message> messages;
    private MessageAdapter adapter;
    private ImageButton sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_with_person);
        messages=new ArrayList<>();
        editText=findViewById(R.id.edittext_input);
        recyclerView=findViewById(R.id.recyclerMessage);

        adapter=new MessageAdapter(messages,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sendButton=findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message=editText.getText().toString();
        if (message.isEmpty()){
            Toast.makeText(this,"write something",Toast.LENGTH_SHORT).show();
            return;
        }
        Random random=new Random();
        Message msg=new Message(message,new Date(),random.nextBoolean());
        messages.add(msg);
        editText.getText().clear();
        adapter.notifyDataSetChanged();
    }
}
