package com.example.culdesac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaUsuarios extends AppCompatActivity {

    ArrayList<String> listDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listDatos = new ArrayList<String>();

        listDatos.add("Adrien");
        listDatos.add("Amelia");
        listDatos.add("Angelina");
        listDatos.add("Arcturus");
        listDatos.add("Ares");
        listDatos.add("Bonnie");
        listDatos.add("Bull");
        listDatos.add("Busy Guy");
        listDatos.add("Emporio");

        AdapterDatosUsuarios adapter = new AdapterDatosUsuarios(listDatos);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Click en: "+ listDatos.get(recycler.getChildAdapterPosition(view)), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Chat.class);
                startActivity(intent);
            }
        });
        recycler.setAdapter(adapter);

        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recycler.addItemDecoration(divider);
    }
}