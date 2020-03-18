package com.example.logincafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class tiposcafes extends AppCompatActivity {
    private ArrayList<modelocafe> cafes;

    private ArrayList<modelocafe> cafespedidos;

    ArrayList<String> ListDatos;
    RecyclerView recycler;
    TextView CantCarrito;
    int aux;
    AlertDialog DialogFiltros;
    MaterialCardView carritodecompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiposcafes);
        hideSystemUI(getWindow());
        CantCarrito=findViewById(R.id.carrtio);
        recycler=findViewById(R.id.recy);
        carritodecompras=findViewById(R.id.carritodecompras);
        recycler.setLayoutManager(new GridLayoutManager(this, 2,RecyclerView.HORIZONTAL,false ));

        cafes=new ArrayList<>();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        llenarcafes();
        final adaptador adap=new adaptador(cafes);
        adap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFiltro(cafes.get(recycler.getChildAdapterPosition(v)).getName(),cafes.get(recycler.getChildAdapterPosition(v)).getImage(),cafes.get(recycler.getChildAdapterPosition(v)).getPrice());
                DialogFiltros.show();

            }
        });
        recycler.setAdapter(adap);


        carritodecompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void llenarcafes() {
        cafes.add(new modelocafe(R.drawable.americano,"Americano","$60"));
        cafes.add(new modelocafe(R.drawable.capuchino,"Capuchino","$60"));
        cafes.add(new modelocafe(R.drawable.conleche,"Con leche","$60"));
        cafes.add(new modelocafe(R.drawable.latte,"Late","$60"));
        cafes.add(new modelocafe(R.drawable.expreso,"Expreso","$60"));
        cafes.add(new modelocafe(R.drawable.mochiato,"Mochiato","$60"));
        cafes.add(new modelocafe(R.drawable.caliente,"Agua caliente","$60"));
        cafes.add(new modelocafe(R.drawable.americano,"Sencilla","$60"));
        cafes.add(new modelocafe(R.drawable.americano,"Combiando","$60"));
        cafes.add(new modelocafe(R.drawable.americano,"variado","$60"));

    }

    public void hideSystemUI(Window window) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI(getWindow());




        }
    }

    private void DialogFiltro(final String Nombre, final int Imagen , final String Precio)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view =View.inflate(getApplicationContext(),R.layout.dialogimagencarta,null);
        ImageView imagen=view.findViewById(R.id.ImagenCarta);
        final TextView nombre=view.findViewById(R.id.nombre);
        Button añadir=view.findViewById(R.id.añadir);
        Button cancelar=view.findViewById(R.id.cancelarañadir);

        imagen.setImageResource(Imagen);
        nombre.setText(Nombre);
        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux++;
                CantCarrito.setText(aux+"");
                cafespedidos.add(new modelocafe(Imagen,Nombre,Precio));
                DialogFiltros.dismiss();

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFiltros.dismiss();

            }
        });
        builder.setCancelable(false);
        builder.setView(view);
        DialogFiltros=builder.create();


    }
}

