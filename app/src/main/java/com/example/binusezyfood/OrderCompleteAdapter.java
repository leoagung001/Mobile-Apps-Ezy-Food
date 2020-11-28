package com.example.binusezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteAdapter extends RecyclerView.Adapter<OrderAdapter.PilihanViewHolder>{

    private ArrayList<Pilihan> pilihanList;
    private Context context;

    public OrderCompleteAdapter(ArrayList<Pilihan> pilihanList, Context context) {
        this.pilihanList = pilihanList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.PilihanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_order_completed, parent, false);
        return new OrderAdapter.PilihanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.PilihanViewHolder holder, int position) {
        final Pilihan pilihan = pilihanList.get(position);
        holder.ivFoto.setImageResource(pilihan.getFoto());
        holder.tvHarga.setText("Rp "+pilihan.getHarga());
        holder.tvNama.setText(pilihan.getNama());
        holder.qty.setText(""+pilihan.getQuantity());
        holder.totalPirces.setText("Total Rp. " + pilihan.getQuantity() * pilihan.getHarga());

    }

    @Override
    public int getItemCount() {
        return pilihanList.size();
    }

    public static class PilihanViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivFoto;
        public TextView tvNama, tvHarga, qty, totalPirces;

        public PilihanViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.imageView2);
            tvNama = itemView.findViewById(R.id.textView3);
            tvHarga = itemView.findViewById(R.id.textView4);
            qty = itemView.findViewById(R.id.quantity_ordered);
            totalPirces = itemView.findViewById(R.id.total_oneproduct);
        }
    }

}
