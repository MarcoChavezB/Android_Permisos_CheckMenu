package com.example.solicitarpermisoview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;

import com.example.solicitarpermisoview.Models.Permiso;
import com.example.solicitarpermisoview.Models.PermisoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView;
        setContentView(R.layout.activity_main);

        List<Permiso> infoPermisos = new ArrayList<>();

        infoPermisos.add(new Permiso("Telefono", android.Manifest.permission.CALL_PHONE));
        infoPermisos.add(new Permiso("Camara", Manifest.permission.CAMERA));
        infoPermisos.add(new Permiso("Mensajes", Manifest.permission.SEND_SMS));

        PermisoAdapter permisoAdapter = new PermisoAdapter(infoPermisos);
        recyclerView = findViewById(R.id.recycler);

        recyclerView.setAdapter(permisoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }
}