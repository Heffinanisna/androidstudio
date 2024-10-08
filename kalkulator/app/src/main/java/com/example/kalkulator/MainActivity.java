package com.example.kalkulator;

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

    TextView tvhasil;
    EditText etbil_1, etbil_2;

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
        tvhasil = findViewById(R.id.tvhasil);
        etbil_1 = findViewById(R.id.etbil_1);
        etbil_2 = findViewById(R.id.etbil_2);
    }

    public void btnjumlah(View view) {

        if (etbil_1.getText().toString().equals("") || etbil_2.getText().toString().equals("")) {
            Toast.makeText(this, "ada bilangan kosong", Toast.LENGTH_SHORT).show();
        } else {

            Double bil_1 = Double.parseDouble(etbil_1.getText().toString());
            Double bil_2 = Double.parseDouble(etbil_2.getText().toString());

            Double hasil = bil_1 + bil_2;
            tvhasil.setText(hasil + "");
        }
    }
}