package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton contacts;
    ImageButton camera;
    protected void initButtons(){
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactsActivity= new Intent(getApplicationContext(), Contacts.class);
                startActivity(contactsActivity);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts=findViewById(R.id.btn_contacts);
        camera=findViewById(R.id.btn_camera);

        initButtons();
    }
}
