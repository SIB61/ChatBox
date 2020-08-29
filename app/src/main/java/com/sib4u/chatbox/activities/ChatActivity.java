package com.sib4u.chatbox.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sib4u.chatbox.R;
import com.sib4u.chatbox.adapters.chatAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
private ImageButton button;
private EditText editText;
private RecyclerView recyclerView;
private chatAdapter adapter;
private List<String> msgList;
private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        button=findViewById(R.id.sendButton);
        editText=findViewById(R.id.msgEditText);
        recyclerView=findViewById(R.id.chat);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);


        msgList=new ArrayList<>();
        adapter=new chatAdapter(getApplicationContext(),msgList);
        recyclerView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=editText.getText().toString().trim();
                if(msg.length()>0)
                {
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    if(!isVisible()){
                        recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount()-1);
                    }
                    editText.setText(null);
                }
            }

            private boolean isVisible() {
                return linearLayoutManager.findLastCompletelyVisibleItemPosition()>recyclerView.getAdapter().getItemCount();
            }
        });
    }
}