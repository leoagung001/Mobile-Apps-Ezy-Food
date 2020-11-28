package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button myorder = (Button) findViewById(R.id.myorder);
        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MyOrder.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();
        ArrayList<Pilihan> pilihans = new ArrayList<>();
        Intent intent = getIntent();
        String names = intent.getStringExtra("name");

        recyclerView = findViewById(R.id.recycler);

        if (names.equals("drinks")){
            pilihans = getDrinks();
        }else if(names.equals("foods")){
            pilihans = getFoods();
        }else if(names.equals("snacks")){
            pilihans = getSnacks();
        }else{
            pilihans = getTopUp();
        }

        adapter = new Adapter(pilihans, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Pilihan> getTopUp() {
        ArrayList<Pilihan> topup = new ArrayList<>();
        topup.add(new Pilihan(R.drawable.telkom, 49500, "Pulsa 50.000", 0));
        topup.add(new Pilihan(R.drawable.telkom, 98000, "Pulsa 100.000", 0));
        topup.add(new Pilihan(R.drawable.xl, 49200, "Pulsa 50.000", 0));
        topup.add(new Pilihan(R.drawable.xl, 97500, "Pulsa 100.000", 0));
        topup.add(new Pilihan(R.drawable.tri, 49000, "Pulsa 50.000", 0));
        topup.add(new Pilihan(R.drawable.tri, 97000, "Pulsa 100.000", 0));
        return topup;
    }

    private ArrayList<Pilihan> getDrinks(){
        ArrayList<Pilihan> drinks = new ArrayList<>();
        drinks.add(new Pilihan(R.drawable.aqua, 5000, "Aqua", 0));
        drinks.add(new Pilihan(R.drawable.boba, 18000, "Boba (Best Seller)", 0));
        drinks.add(new Pilihan(R.drawable.kopi, 10000, "Black Coffee", 0));
        drinks.add(new Pilihan(R.drawable.jusmangga, 12000, "Manggo Juice", 0));
        drinks.add(new Pilihan(R.drawable.jusapel, 10000, "Apple Juice", 0));
        drinks.add(new Pilihan(R.drawable.jusalpukat, 12000, "Avocado Juice", 0));
        return drinks;
    }

    private ArrayList<Pilihan> getSnacks(){
        ArrayList<Pilihan> snacks = new ArrayList<>();
        snacks.add(new Pilihan(R.drawable.rotitawar, 12000, "Roti Tawar", 0));
        snacks.add(new Pilihan(R.drawable.lays, 9500, "Lays", 0));
        snacks.add(new Pilihan(R.drawable.chitatos, 13500, "Chitatos", 0));
        snacks.add(new Pilihan(R.drawable.leo, 4500, "Leo", 0));
        return snacks;
    }

    private ArrayList<Pilihan> getFoods(){
        ArrayList<Pilihan> foods = new ArrayList<>();
        foods.add(new Pilihan(R.drawable.ayamgeprek, 15000, "Ayam Geprek", 0));
        foods.add(new Pilihan(R.drawable.seafood, 55000, "Seafood (Best Seller)", 0));
        foods.add(new Pilihan(R.drawable.bakmie, 12000, "Bak Mie", 0));
        foods.add(new Pilihan(R.drawable.nasigoreng, 12000, "Fried Rice", 0));
        return foods;
    }

}
