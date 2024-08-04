package com.example.sqlitedatabase;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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
