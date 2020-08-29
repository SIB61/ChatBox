package com.sib4u.chatbox.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sib4u.chatbox.R;

import java.util.concurrent.Executor;

public class OtpActivity extends AppCompatActivity {
private Intent intent;
private  String code;
private  EditText editText;
private  ImageButton imageButton;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        intent=getIntent();
        code = intent.getStringExtra("CODE");
        editText=findViewById(R.id.otpID);
        imageButton=findViewById(R.id.verifyID);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp=editText.getText().toString().trim();
                if(otp.length()!=6)
                {

                }
                else
                {
                    try {
                        PhoneAuthProvider phoneAuthProvider=PhoneAuthProvider.getInstance(mAuth);
                        PhoneAuthCredential credential= phoneAuthProvider.getCredential(code,otp);
                        signInWithPhoneAuthCredential(credential);
                    }
                    catch (Exception e){
                        Log.d("OtpActivity",e.getMessage()+"   EXCEPTION FOUND");
                    }
                }
            }
        });

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    updateUi();
                                    // ...
                                } else {
                                    // Sign in failed, display a message and update the UI
                                    Log.w("Tag", "signInWithCredential:failure", task.getException());
                                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                        // The verification code entered was invalid
                                    }
                                }

                            }
                        }
                    );
                }

       private  void updateUi(){
            startActivity(new Intent(OtpActivity.this, MainActivity2.class));
        }
    }