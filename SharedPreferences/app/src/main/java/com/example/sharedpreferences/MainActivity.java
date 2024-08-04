package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView etbarang, etstok;
    SharedPreferences sharedPreferences;

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
    }

    public void load (){
        etbarang = findViewById(R.id.etbarang);
        etstok = findViewById(R.id.etstok);
        sharedPreferences = getSharedPreferences("barang",MODE_PRIVATE);
    }

    public void isiSharedPreferences(String barang, float stok){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("barang", barang);
        editor.putFloat("stok", stok);
        editor.apply();
    }

    public void simpan(View view) {
        String barang = etbarang.getText().toString();
        float stok = Float.parseFloat(etstok.getText().toString());

        if (barang.isEmpty() || stok == 0.0){
            Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show();
        }else{
            isiSharedPreferences(barang,stok);
            Toast.makeText(this, "Data Sudah Disimpan", Toast.LENGTH_SHORT).show();
        }
        etbarang.setText("");
        etstok.setText("");
    }

    public void tampil(View view) {
    }
}