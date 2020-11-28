package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderAdapter adapter;
    ArrayList<Pilihan> order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        int totals=0;
        getSupportActionBar().hide();

        loadData();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize((true));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button pay = (Button) findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyOrder.this, OrderComplete.class);
                startActivity(intent);
            }
        });

        adapter = new OrderAdapter(order, MyOrder.this);
        recyclerView.setAdapter(adapter);


        for (int i = 0; i< order.size();i++){
            Pilihan pilihan = order.get(i);
            totals += (pilihan.getQuantity() * pilihan.getHarga());
        }

        TextView textView = findViewById(R.id.total);
        textView.setText("Rp " + totals);
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson= new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Pilihan>>(){}.getType();
        order = gson.fromJson(json, type);

        if(order == null){
            order = new ArrayList<>();
        }
    }
}
