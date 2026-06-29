package com.example.proyrecyclerview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String []nombres={"Anticucho","Bisteck","Ceviche",
            "CuyFrito","Huancaina","Juane","Mondongo","Pachamanca"};
    float []precios={14,35,30,40,12,35,18,32};
    int []fotos={R.drawable.anticuchos,R.drawable.bistec,R.drawable.ceviche,
            R.drawable.cuy,R.drawable.huancaina,R.drawable.juane,R.drawable.mondogo,R.drawable.pachamanca};
    RecyclerView rv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rv1=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);
        rv1.setAdapter(new AdaptadorPlatos());

    }

    private class AdaptadorPlatos extends RecyclerView.Adapter<AdaptadorPlatos.AdaptadorPlatosHolder> {
        @NonNull
        @Override
        public AdaptadorPlatosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPlatosHolder(getLayoutInflater().inflate(R.layout.itemplato, parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPlatosHolder holder, int position) {
            holder.imprimir(position);

        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        private class AdaptadorPlatosHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView tv1, tv2;
            ImageView iv1;

            public AdaptadorPlatosHolder(@NonNull View itemView) {
                super(itemView);
                iv1=itemView.findViewById(R.id.imageView);
                tv1=itemView.findViewById(R.id.tvNombre);
                tv2=itemView.findViewById(R.id.tvPrecio);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText(String.valueOf(precios[position]));

            }

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,nombres[getLayoutPosition()], Toast.LENGTH_SHORT).show();

            }
        }
    }
}