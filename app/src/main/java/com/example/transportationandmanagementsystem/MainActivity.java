package com.example.transportationandmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button search;
    TextView to;
    Spinner from;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = findViewById(R.id.search);
        from = findViewById(R.id.from);
        to = findViewById(R.id.to);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.route, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(adapter);
        from.setOnItemSelectedListener(this);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowAvailableBus.class);
                startActivity(intent);


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text =  parent.getItemAtPosition(position).toString();
      if(position==0){
          to.setText("Daffodil Smart City");
      }else{
          to.setText("Main Campus");
      }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}