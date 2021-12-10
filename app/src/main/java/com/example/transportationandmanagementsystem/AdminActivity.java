package com.example.transportationandmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class AdminActivity extends AppCompatActivity {
    Button button;
    EditText inputText;


    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        button = findViewById(R.id.addButton);
        inputText = findViewById(R.id.inputText);


        mRef = FirebaseDatabase.getInstance().getReference("BUSES");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBus();
            }
        });


    }

    private void insertBus() {

        String name = inputText.getText().toString();
        if (!name.equals("")) {
            Buses buses = new Buses(name);
            mRef.push().setValue(buses);
            Toast.makeText(AdminActivity.this, "PUSHED " + name, Toast.LENGTH_LONG).show();
            inputText.setText("");
        }

    }
}