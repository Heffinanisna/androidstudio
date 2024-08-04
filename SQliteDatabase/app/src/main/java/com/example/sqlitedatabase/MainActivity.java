package com.example.sqlitedatabase;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etbarang,etstok,etharga;
    TextView tvpilihan;

    List<Barang> databarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvbarang;

    String idbarang;

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
        selectData();
    }

    public void load (){
        db = new Database(this);
        db.buatTabel();

        etbarang = findViewById(R.id.etbarang);
        etstok = findViewById(R.id.etstok);
        etharga = findViewById(R.id.etharga);
        tvpilihan = findViewById(R.id.tvpilihan);
        rcvbarang = findViewById(R.id.rcvbarang);

        rcvbarang.setLayoutManager(new LinearLayoutManager(this));
        rcvbarang.setHasFixedSize(true);
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
                if (db.runSQL()){
                    pesan("insert berhasil");
                    selectData();
                }else {
                    pesan("insert gagal");
                }
            }else{
                String sql = "UPDATE tblbarang\n" +
                        "SET barang = \'"+barang+"',stok = "+stok+", harga = "+harga+"\n" +
                        "WHERE idbarang = "+idbarang+";";

                if (db.runSQL(sql)){
                    pesan("Data Sudah Diubah");
                    selectData();
                }else {
                    pesan("Data Tidak Bisa Diubah");
                }
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

    public void selectData (){
        String sql = "SELECT*FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);
        databarang.clear();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                @SuppressLint("Range") String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                @SuppressLint("Range") String barang = cursor.getString(cursor.getColumnIndex("barang"));
                @SuppressLint("Range") String stok = cursor.getString(cursor.getColumnIndex("stok"));
                @SuppressLint("Range") String harga = cursor.getString(cursor.getColumnIndex("harga"));

                databarang.add(new Barang(idbarang,barang,stok,harga));
            }

            adapter = new BarangAdapter(this,databarang);
            rcvbarang.setAdapter(adapter);
            adapter.notify();

        }else {
            pesan("Data Kosong");
        }
    }

    public void deletedata (String id){
        idbarang = id;


        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("PERINGATAN !");
        al.setMessage("Yakin Akan Menghapus ?");
        al. setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String sql = "DELETE FROM tblbarang WHERE idbarang = "+idbarang+";";
                if (db.runSQL(sql)){
                    pesan("Data Sudah Dihapus");
                    selectData();
                }else {
                    pesan("Data Tidak Bisa Dihapus");
                }

            }
        })
        al.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();

            }
        });

        al.show();


    }

    @SuppressLint("Range")
    public void selectupdate (String id){
        idbarang = id;
        String sql = "SELECT * FROM tblbabrang WHRE idbarang = "+id+";";
        Cursor cursor = db.select(sql);
        cursor.moveToNext();

        etbarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etstok.setText(cursor.getString(cursor.getColumnIndex("stok")));
        etharga.setText(cursor.getString(cursor.getColumnIndex("harga")));

        tvpilihan.setText("update");
    }
}