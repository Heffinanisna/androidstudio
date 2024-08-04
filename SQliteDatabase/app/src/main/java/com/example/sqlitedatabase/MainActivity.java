package com.example.sqlitedatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etbarang,etstok,etharga;
    TextView tvpilihan;

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
        db = new Database(this);
        db.buatTabel();

        etbarang = findViewById(R.id.etbarang);
        etstok = findViewById(R.id.etstok);
        etharga = findViewById(R.id.etharga);
        tvpilihan = findViewById(R.id.tvpilihan);
    }

    public void simpan (View v){
        String barang = etbarang.getText().toString();
        String stok = etstok.getText().toString();
        String harga = etharga.getText().toString();
        String pilihan = tvpilihan.getText().toString();

        if (barang.isEmpty()|| stok.isEmpty() || harga.isEmpty()){
            pesan("Data Kosong");
        }else {
            if (pilihan.equals("insert")){
                pesan("insert");
                String sql = "INSERT INTO tblbarang (barang,stok,harga) VALUES ('"+barang+"',"+stok+","+harga+")";
                pesan(sql);
            }else{
                pesan("update");
            }
        }
        etbarang.setText("");
        etstok.setText("");
        etharga.setText("");
        tvpilihan.setText("insert");
    }

    public void pesan (String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }
}