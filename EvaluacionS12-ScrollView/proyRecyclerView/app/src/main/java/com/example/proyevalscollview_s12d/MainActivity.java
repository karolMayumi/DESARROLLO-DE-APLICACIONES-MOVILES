package com.example.proyevalscollview_s12d;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    String fruta = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tvtitulo);

        int num = (int) (Math.random() * 8);

        switch (num) {
            case 0: fruta = "Fresa"; break;
            case 1: fruta = "Kiwi"; break;
            case 2: fruta = "Manzana"; break;
            case 3: fruta = "Melon"; break;
            case 4: fruta = "Naranja"; break;
            case 5: fruta = "Papaya"; break;
            case 6: fruta = "Platano"; break;
            case 7: fruta = "Piña"; break;
        }


        tv1.setText("Seleccione la fruta\n" + fruta);
    }

    public void presionar(View v) {
        ImageButton ib = (ImageButton) v;

        if (ib.getTag().toString().equals(fruta)) {
            Toast.makeText(this, "Muy Bien", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Incorrecto seleccionaste la fruta " + ib.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}