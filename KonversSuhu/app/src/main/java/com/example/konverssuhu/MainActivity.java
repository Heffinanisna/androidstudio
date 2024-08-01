package com.example.konverssuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etnilai;
    TextView tvhasil;

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
    public void load(){
        spinner = findViewById(R.id.spinner);
        etnilai = findViewById(R.id.etnilai);
        tvhasil = findViewById(R.id.tvhasil);
    }
    /*
    public void isiSpinner(){
        String[] isi = {"Celcius to Reamur","Celius to Fahreinheit","Celcius to Kelvin"};
        ArrayAdapter<String>adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
    */

    public void btnkonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etnilai.getText().toString().equals("")){
            Toast.makeText(this,"nilai tidak boleh kosong",Toast.LENGTH_SHORT).show();

        }else{
            if (pilihan.equals("Celcius to Reamur")){
                cToR();
            }
            if (pilihan.equals("Celcius to Fahreinheit")){
                cToF();
            }
        }


    }

    public void cToR(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (4.0/5.0)*suhu;

        tvhasil.setText(hasil+"");
    }
    public void cToF(){
        Toast.makeText(this,"belum dibuat",Toast.LENGTH_SHORT).show();
    }
}