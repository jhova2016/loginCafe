package com.example.logincafe;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolderDatos> implements View.OnClickListener {


    TextView nombrecafe;
    TextView preciocafe;

    private ArrayList<modelocafe> ListDatos;
    private View.OnClickListener listener;
    ImageView cardImage;

    private AlertDialog DialogFiltros;
    int CantidadCarrito;


    public adaptador(ArrayList<modelocafe> listDatos) {
        ListDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.nombrecafe.setText(ListDatos.get(position).getName());
        holder.preciocafe.setText(ListDatos.get(position).getPrice());
        holder.foto.setImageResource(ListDatos.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return ListDatos.size();
    }
public  void setOnClickListener(View.OnClickListener listener)
{
   this.listener=listener;


}
    @Override
    public void onClick(View v) {
        if (listener!=null)
        {
            listener.onClick(v);

        }

    }

    class ViewHolderDatos extends RecyclerView.ViewHolder  {
        TextView nombrecafe;
        TextView preciocafe;
        ImageView foto;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombrecafe=itemView.findViewById(R.id.nombrecafe);
            preciocafe=itemView.findViewById(R.id.preciocafe);
            foto=itemView.findViewById(R.id.foto);


        }


    }
}
