package com.sib4u.chatbox.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sib4u.chatbox.R;
import com.sib4u.chatbox.models.UserModel;
import com.sib4u.chatbox.adapters.StoryAdapter;
import com.sib4u.chatbox.adapters.chatOptionAdapter;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sib4u.chatbox.R.id.imageView3;

public class MainActivity2 extends AppCompatActivity implements chatOptionAdapter.Listener {
private RecyclerView recyclerView,recyclerView1;
private UserModel userModel;
private List<UserModel> userModels;
private StoryAdapter adapter;
private FloatingActionButton fab;
private ImageButton imageButton;
private  Uri imageUri;

ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView=findViewById(imageView3);
        fab=findViewById(R.id.fabID);
        recyclerView1=findViewById(R.id.chatID);
        recyclerView=findViewById(R.id.storyID);
        imageButton=findViewById(R.id.addStory);

        userModels=new ArrayList<>();
        recyclerView1.setAdapter(new chatOptionAdapter(this,this));

        adapter=new StoryAdapter(userModels,this);
        recyclerView.setAdapter(adapter);


        imageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        verifyStoragePermission();
                    }

                }
        );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(getApplicationContext(), ContactListActivity.class));
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT);
                }
            }
        });


        for(int i=0;i<20;i++)
        {
           userModel=new UserModel("sabit",null,null,null);
           userModels.add(userModel);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void clickListener(int position) {
       startActivity(new Intent(MainActivity2.this, ChatActivity.class));
    }

    private void verifyStoragePermission() {
            String permissions[]={Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
            if(ContextCompat.checkSelfPermission(this,permissions[0])== PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this,permissions[1])== PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this,permissions[2])== PackageManager.PERMISSION_GRANTED)
            {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),2);

            }
            else {
                ActivityCompat.requestPermissions(this,permissions,1);
            }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2&&requestCode==RESULT_OK)
        {
            imageUri = data.getData();
            Picasso.get().load(imageUri).into(imageView);
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}