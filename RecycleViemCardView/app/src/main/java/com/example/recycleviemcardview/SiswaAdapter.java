package com.example.recycleviemcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "nama : "+siswa.getnama()+"alamat: "+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvnama, tvalamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvnama = itemView.findViewById(R.id.tvnama);
            tvalamat = itemView.findViewById(R.id.tvalamat);
        }
    }
}
