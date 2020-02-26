package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Contacts extends AppCompatActivity {
    protected void init(){
        Intent permission= new Intent(getApplicationContext(), PermissionInfo.class);
        startActivity(permission);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        init();
    }
}
