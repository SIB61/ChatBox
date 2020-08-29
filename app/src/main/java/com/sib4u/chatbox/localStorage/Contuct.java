package com.sib4u.chatbox.localStorage;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;

import androidx.annotation.RequiresApi;

import com.sib4u.chatbox.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class Contuct {
    Context context;

    public Contuct(Context context) {
        this.context = context;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<UserModel> getContacts() {
        List<UserModel> returnList = new ArrayList<>();
        String name, number, photo;
        UserModel userModel;
        Cursor cur = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null);
     //   name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
       // number = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        //photo = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
        //UserModel userModel = new UserModel(name, number, photo);
        //returnList.add(userModel);
        while (cur.moveToNext()) {
            name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            number = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            photo = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
            userModel = new UserModel(name, number, photo,null);
            returnList.add(userModel);
        }
        return returnList;
    }
}








 /* Dexter.withContext(getContext()).withPermission(Manifest.permission.READ_CONTACTS).withListener(
                new PermissionListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        if (permissionGrantedResponse.getPermissionName().equals(Manifest.permission.READ_CONTACTS)) {
                            try {
                                userModels = new Contuct(getContext()).getContacts();
                                adapter=new ConAdapter(getContext(),userModels);
                                recyclerView.setAdapter(adapter);
                            }
                            catch (Exception e) {
                                Toast .makeText(getContext(),"failed",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(getContext(), "permission should be granted", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }
        ).check();*/




