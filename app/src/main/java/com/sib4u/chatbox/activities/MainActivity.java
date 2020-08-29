package com.sib4u.chatbox.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sib4u.chatbox.R;

public class MainActivity extends AppCompatActivity {
   private  final int TIME = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            Intent intent;
            @Override
            public void run() {
                FirebaseAuth mAuth=FirebaseAuth.getInstance();
                FirebaseUser user=mAuth.getCurrentUser();
                if(user!=null)
                {
                    intent=new Intent(MainActivity.this, MainActivity2.class);
                }
                else
                {
                    intent=new Intent(MainActivity.this, LoginActivity.class);
                }
               startActivity(intent);
               finish();
            }
        },TIME);
    }
}