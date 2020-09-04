package com.sib4u.chatbox.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;
import com.sib4u.chatbox.Fragments.Login_Fragment;
import com.sib4u.chatbox.Fragments.Register_Fragment;
import com.sib4u.chatbox.R;
import com.sib4u.chatbox.firebaseRepo.Auth;

public class LoginActivity extends AppCompatActivity {

    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        fragment=new Register_Fragment ();
        getSupportFragmentManager ().beginTransaction ().add ( R.id.Sign_Frame,fragment ).commit ();
    }

    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }
}
