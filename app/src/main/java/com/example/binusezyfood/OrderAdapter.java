package com.example.binusezyfood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.PilihanViewHolder>{

    private ArrayList<Pilihan> pilihanList;
    private Context context;

    public OrderAdapter(ArrayList<Pilihan> pilihanList, Context context) {
        this.pilihanList = pilihanList;
        this.context = context;
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

    @NonNull
    @Override
    public OrderAdapter.PilihanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_ordered, parent, false);
        return new OrderAdapter.PilihanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PilihanViewHolder holder, final int position) {
        final Pilihan pilihan = pilihanList.get(position);
        holder.ivFoto.setImageResource(pilihan.getFoto());
        holder.tvHarga.setText("Rp "+pilihan.getHarga());
        holder.tvNama.setText(pilihan.getNama());
        holder.qty.setText(""+pilihan.getQuantity());
        holder.totalPirces.setText("Total Rp. " + pilihan.getQuantity() * pilihan.getHarga());

        Button tvDelet = holder.itemView.findViewById(R.id.delete);

        tvDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilihanList.remove(position);

                SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson= new Gson();
                String json = gson.toJson(pilihanList);
                editor.putString("task list", json);
                editor.apply();

                if(pilihanList.size() == 0){
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivities(new Intent[]{intent});
                }else{
                    Intent intent = new Intent(context, MyOrder.class);
                    context.startActivities(new Intent[]{intent});
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return pilihanList.size();
    }


}
