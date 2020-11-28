package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Button myorder = (Button) findViewById(R.id.myorder);
        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyOrder.class);
                startActivity(intent);
            }
        });

    }

    public void goToFoods(View view) {
        Intent data;
        data = new Intent(this, Menu.class);
        data.putExtra("name","foods");
        startActivity(data);
    }

    public void goToTopUp(View view) {
        Intent data;
        data = new Intent(this, Menu.class);
        data.putExtra("name","topup");
        startActivity(data);
    }

    public void goToDrinks(View view) {
        Intent data;
        data = new Intent(this, Menu.class);
        data.putExtra("name","drinks");
        startActivity(data);
    }

    public void goToSnacks(View view) {
        Intent data;
        data = new Intent(this, Menu.class);
        data.putExtra("name","snacks");
        startActivity(data);
    }


}
