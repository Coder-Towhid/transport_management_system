package com.example.transportationandmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class AdminActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button;
    EditText busname,busseats,schedule;
    Spinner  route;
    String  rt;
    FirebaseDatabase db;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        button = findViewById(R.id.addButton);
        busname = findViewById(R.id.BusName);
        schedule =  findViewById(R.id.BusSchedule);
        busseats = findViewById(R.id.BusSeats);
        route = findViewById(R.id.route);


        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this, R.array.route, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        route.setAdapter(ad);
        route.setOnItemSelectedListener(this);



        mRef = FirebaseDatabase.getInstance().getReference("BUSES");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBus();

            }
        });


    }

    private void insertBus() {

        String name = busname.getText().toString();
        String sdl = schedule.getText().toString();
        String seats = busseats.getText().toString();


        if (!name.equals("") && !seats.equals("")) {
            db = FirebaseDatabase.getInstance();
            mRef = db.getReference("buses");
            Buses buses = new Buses(name, sdl, seats, rt);
            mRef.push().setValue(buses);

            busname.setText("");
            schedule.setText("");
            busseats.setText("");

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         rt =  parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}