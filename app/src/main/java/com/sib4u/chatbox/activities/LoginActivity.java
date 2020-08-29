package com.sib4u.chatbox.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.sib4u.chatbox.R;
import com.sib4u.chatbox.firebaseRepo.Auth;

public class LoginActivity extends AppCompatActivity {
    private String phoneNumber;
    PhoneAuthProvider phoneAuthProvider;
    Button  verify;
    ImageButton send;
   // FirebaseAuth mAuth;
    String mVerificationId;
    ProgressBar progressBar;
    EditText PhoneNumber, Otp;
    CountryCodePicker ccp;
    Auth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // mAuth=FirebaseAuth.getInstance();
        send=findViewById(R.id.sendID);
        ccp=findViewById(R.id.ccpID);
        ccp.setDefaultCountryUsingNameCode("BD");
        PhoneNumber=findViewById(R.id.phnID);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               phoneNumber="+"+ccp.getSelectedCountryCode()+PhoneNumber.getText().toString().trim();
              // String code= new Auth(LoginActivity.this).sendCode(phoneNumber);

              if(!isConnected())
              {
                  Toast.makeText(getApplicationContext(),"check internet connection",Toast.LENGTH_SHORT).show();
              }

             else {

                   mAuth=new Auth(LoginActivity.this);
                   String code=  mAuth.sendCode("+8801792474468");
                   Toast.makeText(getApplicationContext(),
                           code,Toast.LENGTH_SHORT);
                  // if(code.length()==6) {
                       Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
                       intent.putExtra("CODE", code);
                       startActivity(intent);
                 //  }
               }
            }
        });
    }


    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }
}
