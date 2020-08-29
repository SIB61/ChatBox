package com.sib4u.chatbox.firebaseRepo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthSettings;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class Auth {
    Context ctx;
    Activity activity;
    private  String CODE;
    private FirebaseAuth mAuth;
    public Auth() {
    }

    public Auth(Activity activity) {
        this.activity = activity;
    }

    public  String sendCode(String phoneNumber) {
        mAuth=FirebaseAuth.getInstance();
        FirebaseAuthSettings firebaseAuthSettings=mAuth.getFirebaseAuthSettings();
        firebaseAuthSettings.setAutoRetrievedSmsCodeForPhoneNumber(phoneNumber,"123456");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                activity,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential
                                                                phoneAuthCredential) {


                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        CODE=e.getMessage();
                    }

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        CODE =s;
                    }
                }
        );
        return  CODE;
    }




    }





