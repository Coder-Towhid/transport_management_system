package com.example.transportationandmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowAvailableBus extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_available_bus);
        listView = findViewById(R.id.avlBus);
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter =  new ArrayAdapter<String>(this,R.layout.list_item, list);
        listView.setAdapter(adapter);

        DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("buses");
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for(DataSnapshot dataSnapshot : snapshot.getChildren() ){
                    Buses buses = dataSnapshot.getValue(Buses.class);
                    String busname = buses.getName();
                    String busschedule = buses.getSchedule();
                    String busroute = buses.getRoute();
                    String busseat = buses.getSeat();
                    list.add(busname);
                    list.add(busschedule);
                    list.add(busroute);
                    list.add(busseat);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}