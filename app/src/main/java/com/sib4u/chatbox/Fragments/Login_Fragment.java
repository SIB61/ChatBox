package com.sib4u.chatbox.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.PatternMatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.sib4u.chatbox.R;
import com.sib4u.chatbox.activities.LoginActivity;
import com.sib4u.chatbox.activities.MainActivity2;

import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.internal.Util;

import static android.content.ContentValues.TAG;


public class Login_Fragment extends Fragment {

    private ImageButton imageButton;
    private ImageButton imageButton2;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private EditText name,email,pass,rePass;
    public Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate ( R.layout.fragment_login_, container, false );
       name=view.findViewById ( R.id.Name );
       email=view.findViewById ( R.id.Email );
       pass=view.findViewById ( R.id.Password );
       rePass=view.findViewById ( R.id.rePassword );
       imageButton=view.findViewById ( R.id.SignUpBack );
       imageButton2=view.findViewById ( R.id.signUpButton );
       mAuth=FirebaseAuth.getInstance ();
       imageButton.setOnClickListener ( new View.OnClickListener ( ) {
           @Override
           public void onClick(View view) {
              // getActivity ().startActivity ( new Intent ( getContext (), MainActivity2.class ) );
               getActivity ().getSupportFragmentManager ().beginTransaction ().replace ( R.id.Sign_Frame,new Register_Fragment () ).commit ();
           }
       } );

       imageButton2.setOnClickListener ( new View.OnClickListener ( ) {
           @Override
           public void onClick(View view) {
               String Name=name.getText ().toString ().trim ();
               String Email=email.getText ().toString ().trim ();
               String Pass=pass.getText ().toString ().trim ();
               String RePass=rePass.getText ().toString ().trim ();

               if(Name.isEmpty ()){

               }
               else if(Email.isEmpty ()){

               }
               else if(Pass.isEmpty ()){

               }
               else if(RePass.isEmpty ()){

               }
               else if ( Pass.length ()<6 ){

               }
               else if(Pass.equals ( RePass ) ){

               }
               else if ( !Patterns.EMAIL_ADDRESS.matcher ( Email ).matches () ){

               }
               else {
                   signUp(Email,Pass);
                   //  startActivity ( new Intent ( getContext (), MainActivity2.class ) );
               }
           }
       } );
       return view;
    }

    private void signUp(String email,String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( getActivity (), new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        getActivity ().startActivity ( new Intent ( getContext (), MainActivity2.class ) );
        getActivity ().finish ();
    }
}