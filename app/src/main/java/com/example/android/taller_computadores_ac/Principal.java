package com.example.android.taller_computadores_ac;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorComputador.onComputadorClickListener{
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Computador> computadores;
    private AdaptadorComputador adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String bd="Computadores";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstOpciones);
        computadores = new ArrayList<>();


        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorComputador(computadores, this);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computadores.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computador c=snapshot.getValue(Computador.class);
                        computadores.add(c);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPersonas(computadores);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void crearComputadores(View v){
        i= new Intent(Principal.this,Crear_Computador.class);
        startActivity(i);
        //Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }


    @Override
    public void onComputadorClick(Computador c) {
        Intent i=new Intent(Principal.this,DetalleComputador.class);
        Bundle b=new Bundle();
        b.putString("id",c.getId());
        b.putString("marca",c.getMarca());
        b.putString("ram",c.getRam());
        b.putString("color",c.getColor());
        b.putString("tipo",c.getTipo());
        b.putString("sistema",c.getSistema());
        b.putInt("foto",c.getFoto());

        i.putExtra("datos",b);
        startActivity(i);

    }
}
