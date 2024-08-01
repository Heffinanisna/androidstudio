package com.example.messegedialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    }
    public void showToast (String pesan){
        Toast.makeText(this,"pesan",Toast.LENGTH_SHORT).show();
    }

    public void showAlert (String pesan){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("PERHATIAN!");
        buatAlert.setMessage(pesan);

        buatAlert.show();
    }

    public void showalertbutton (String pesan){
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("PERINGATAN !");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("Data di hapus");
            }
        });
        showAlert.setNegativeButton("TIDAK", new DialogInterface.OnClickListener(){
            @Override
                    public void onClick(DialogInterface dialog, int which){
                        showAlert("data tidak dihapus !");
            }
        });

        showAlert.show();
    }

    public void btntoast(View view) {
        showToast("belajar belajar");
    }

    public void btnalert(View view) {
        showToast("selamat belajar !");
    }

    public void btndialogbutton(View view) {
        showalertbutton("yakin akan menghapus ?");
    }
}