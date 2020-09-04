package com.sib4u.chatbox.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sib4u.chatbox.R;
import com.sib4u.chatbox.activities.MainActivity2;

import static android.content.ContentValues.TAG;

public class Register_Fragment extends Fragment {
   private View view;
   private TextView textView;
   private EditText Email;
   private EditText Pass;
   private ImageButton button;
    private  FirebaseAuth mAuth;
    public Register_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate ( R.layout.fragment_register_, container, false );
        init();
        return view;
    }

    private void init() {
        mAuth=FirebaseAuth.getInstance ();
        textView=view.findViewById ( R.id.gotoSign );
        Email= view.findViewById ( R.id.LoginEmail );
        Pass= view.findViewById ( R.id.LoginPass );
        button=view.findViewById ( R.id.LoginButton );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String email= Email.getText ().toString ().trim ();
                String pass=Pass.getText ().toString ().trim ();
                if(email.isEmpty ()||pass.isEmpty ())
                {
                    Toast.makeText ( getContext (),"Email or Password incorrect",Toast.LENGTH_SHORT ).show ();
                }
                else {
                    signIn(email,pass );
                }
            }
        } );
        textView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                getActivity ().getSupportFragmentManager ().beginTransaction ().replace ( R.id.Sign_Frame,new Login_Fragment () ).commit ();

            }
        } );

    }

    private void signIn(String email,String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity (), new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getContext (), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if ( user == null ) {

        } else {
            startActivity ( new Intent ( getContext (), MainActivity2.class ) );
            getActivity ().finish ();
        }
    }

}