package com.sib4u.chatbox.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sib4u.chatbox.R;
import com.sib4u.chatbox.localStorage.Contuct;
import com.sib4u.chatbox.models.UserModel;
import com.sib4u.chatbox.adapters.ConAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity {
private RecyclerView recyclerView2;
private List<UserModel> userModels;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        userModels=new ArrayList<>();
       recyclerView2=findViewById(R.id.ContactListID);

        Dexter.withContext(this).withPermission(Manifest.permission.READ_CONTACTS).withListener(
                new PermissionListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        if (permissionGrantedResponse.getPermissionName().equals(Manifest.permission.READ_CONTACTS)) {
                            try {
                               userModels=new Contuct(getApplicationContext()).getContacts();
                                recyclerView2.setAdapter(new ConAdapter(ContactListActivity.this,userModels));
                            }
                            catch (Exception e) {
                                Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(getApplicationContext(), "permission should be granted", Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }
        ).check();


    }
}