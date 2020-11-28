package com.example.binusezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.PilihanViewHolder>{

    static final String new_nama = "com.example.application.binusezyfood.new_name";
    static final String new_harga = "com.example.application.binusezyfood.new_harga";
    static final String new_foto = "com.example.application.binusezyfood.new_foto";

    private ArrayList<Pilihan> pilihanList;
    private Context context;

    public Adapter(ArrayList<Pilihan> pilihanList, Context context) {
        this.pilihanList = pilihanList;
        this.context = context;
    }


    class PilihanViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        private TextView tvNama, tvHarga;

        public PilihanViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.jusmangga_img);
            tvNama = itemView.findViewById(R.id.nama);
            tvHarga = itemView.findViewById(R.id.harga);
        }
    }


    @NonNull
    @Override
    public PilihanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new PilihanViewHolder(view);
    }

    //buat tampung data di array
    @Override
    public void onBindViewHolder(@NonNull PilihanViewHolder holder, int position) {
        final Pilihan pilihan = pilihanList.get(position);
        holder.ivFoto.setImageResource(pilihan.getFoto());
        holder.tvHarga.setText("Rp "+pilihan.getHarga());
        holder.tvNama.setText(pilihan.getNama());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailPilihan.class);
                intent.putExtra(new_foto, pilihan.getFoto());
                intent.putExtra(new_harga, pilihan.getHarga());
                intent.putExtra(new_nama, pilihan.getNama());
                context.startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return pilihanList.size();
    }



}
