package com.sib4u.chatbox.localStorage;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class SharedPref {
    private SharedPreferences sharedPreferences;
    private Context ctx;
    public SharedPref(Context ctx){
        this.ctx = ctx;
        sharedPreferences=ctx.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
    }
    public boolean isLogIn(){
        return sharedPreferences.getBoolean("loginStatus",false);
    }
    public void login(){
        sharedPreferences.edit().putBoolean("loginStatus", true);
    }

}
