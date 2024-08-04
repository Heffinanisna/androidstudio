package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BarangAdapter {

    public class ViewHolder extends RecyclerView.Adapter<BarangAdapter.ViewHolder>{

        Context context;
        List<Barang> barangList;


        public ViewHolder(List<Barang> barangList, Context context) {
            this.context = context;
            this.barangList = barangList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_barang,viewGroup,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.tvbarang.setText(barangList.get(i).getBarang());
            viewHolder.tvstok.setText(barangList.get(i).getStok());
            viewHolder.tvharga.setText(barangList.get(i).getHarga());

        }

        @Override
        public int getItemCount() {
            return barangList.size();
        }
        TextView tvbarang, tvstok, tvharga, tvmenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvbarang = itemView.findViewById(R.id.tvbarang);
            tvstok = itemView.findViewById(R.id.tvstok);
            tvharga = itemView.findViewById(R.id.tvharga);
            tvmenu = itemView.findViewById(R.id.tvmenu);

        }
    }

}
