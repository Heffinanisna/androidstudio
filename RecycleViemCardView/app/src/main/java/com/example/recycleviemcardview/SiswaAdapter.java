package com.example.recycleviemcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private Context context;
    private List<Siswa>siswaList;

    public SiswaAdapter(Context context, List<Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder ViewHolder, int i) {
        Siswa siswa = siswaList.get(i);
        ViewHolder.tvnama.setText(siswa.getnama());
        ViewHolder.tvalamat.setText(siswa.getAlamat());

        /*

        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "nama : "+siswa.getnama()+"alamat: "+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
            }
        });
        */
         ViewHolder.tvMenu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PopupMenu popupMenu = new PopupMenu(context,ViewHolder.tvMenu);
                 popupMenu.inflate (R.menu.menu_option);

                 popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     @Override
                     public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                                if (id == R.id.menu_simpan){
                                    Toast.makeText(context, "Simpan Data"+siswa.getnama(), Toast.LENGTH_SHORT).show();
                                }else if (id == R.id.menu_hapus){
                                    siswaList.remove(ViewHolder.getAdapterPosition());
                                    notifyDataSetChanged();
                                    Toast.makeText(context, siswa.getnama()+"Sudah Dihapus", Toast.LENGTH_SHORT).show();
                                }
                         return false;
                     }
                 });

                 popupMenu.show();
             }
         });
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvnama, tvalamat, tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvnama = itemView.findViewById(R.id.tvnama);
            tvalamat = itemView.findViewById(R.id.tvalamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }
}
