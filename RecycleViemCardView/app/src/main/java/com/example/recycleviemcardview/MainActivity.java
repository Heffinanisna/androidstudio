package com.example.recycleviemcardview;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa>siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        load();
        isidata();
    }
    public void load (){
        recyclerView = findViewById(R.id.rcvsiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void isidata(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Jaemin", "Surabaya"));
        siswaList.add(new Siswa("Jeno", "Bandung"));
        siswaList.add(new Siswa("Mark", "Jakarta"));
        siswaList.add(new Siswa("Renjun", "Jogjakarta"));
        siswaList.add(new Siswa("Jisung", "Malang"));
        siswaList.add(new Siswa("Haechan", "Bandung"));
        siswaList.add(new Siswa("Chenle", "Bogor"));

        adapter = new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);

    }

    public void btntambah(View view) {
        siswaList.add(new Siswa("JAEMIN", "SURABAYA"));
        adapter.notifyDataSetChanged();
    }
}