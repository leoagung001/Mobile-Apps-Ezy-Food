package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DetailPilihan extends AppCompatActivity {

    TextView detailTittle;
    ImageView detailImg;
    TextView detailPrice;
    ArrayList<Pilihan> order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pilihan);

        getSupportActionBar().hide();

        Button myorder = (Button) findViewById(R.id.myorder);
        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPilihan.this, MainActivity.class);
                startActivity(intent);
            }
        });

        loadData();

        final String itemName = getIntent().getStringExtra(Adapter.new_nama);
        final int itemPrice = getIntent().getIntExtra(Adapter.new_harga, 0);
        final int itemImg = getIntent().getIntExtra(Adapter.new_foto, 0);
        Button orderSave = findViewById(R.id.order);


        detailPrice = findViewById(R.id.pricesss);
        detailPrice.setText("Rp "+itemPrice);

        detailTittle = findViewById(R.id.namess);
        detailTittle.setText(itemName);

        detailImg = findViewById(R.id.imageView11);
        detailImg.setImageResource(itemImg);


        orderSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.quantity);
                int qty = Integer.parseInt((editText.getText().toString()));
                saveData(itemName, itemPrice, itemImg, qty);
                Toast.makeText(DetailPilihan.this, " Nama Item: "+itemName + ", Price: "+ itemPrice + ", Quantity: " + qty, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void saveData(String itemName, int itemPrice, int itemImg, int qty) {

        order.add(new Pilihan(itemImg, itemPrice, itemName, qty));
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson= new Gson();
        String json = gson.toJson(order);
        editor.putString("task list", json);
        editor.apply();

        Intent intent = new Intent(DetailPilihan.this, MyOrder.class);
        startActivity(intent);

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
