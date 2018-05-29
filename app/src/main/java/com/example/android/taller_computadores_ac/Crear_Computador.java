package com.example.android.taller_computadores_ac;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Crear_Computador extends AppCompatActivity {
    private Spinner cmbmarca;
    private Spinner cmbram;
    private Spinner cmbcolor;
    private Spinner cmbtipo;
    private Spinner cmbsistema;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private ArrayAdapter<String> adapter4;
    private ArrayAdapter<String> adapter5;
    private String opc[];
    private String opc2[];
    private String opc3[];
    private String opc4[];
    private String opc5[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__computador);
        cmbmarca=findViewById(R.id.cmbmarca);
        cmbram=findViewById(R.id.cmbram);
        cmbcolor=findViewById(R.id.cmbcolor);
        cmbtipo=findViewById(R.id.cmbtipo);
        cmbsistema=findViewById(R.id.cmbsistema);

        opc=this.getResources().getStringArray(R.array.smarca);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbmarca.setAdapter(adapter);

        opc2=this.getResources().getStringArray(R.array.sram);
        adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc2);
        cmbram.setAdapter(adapter2);

        opc3=this.getResources().getStringArray(R.array.scolor);
        adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc3);
        cmbcolor.setAdapter(adapter3);

        opc4=this.getResources().getStringArray(R.array.stipo);
        adapter4=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc4);
        cmbtipo.setAdapter(adapter4);

        opc5=this.getResources().getStringArray(R.array.ssistema);
        adapter5=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc5);
        cmbsistema.setAdapter(adapter5);

        fotos= new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
    }


    public void guardar(View v){
        String id,mar, ra, colo,siste,tip;
        int  foto;
        foto=Datos.fotoAleatoria(fotos);
        mar=convetidoratexto(cmbmarca);
        ra=convetidoratexto(cmbram);
        colo=convetidoratexto(cmbcolor);
        tip=convetidoratexto(cmbtipo);
        siste=convetidoratexto(cmbsistema);
        id=Datos.getId();

        Computador c=new Computador(id,mar,ra,colo,tip,siste,foto);
        c.guardar();
        Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        cmbsistema.setSelection(0);
        cmbtipo.setSelection(0);
        cmbcolor.setSelection(0);
        cmbram.setSelection(0);
        cmbmarca.setSelection(0);
    }
    public  void onBackPressed(){
        finish();
        Intent i= new Intent(Crear_Computador.this,Principal.class);
        startActivity(i);
    }
    public String convetidoratexto(Spinner s){
        String txt=s.getSelectedItem().toString();
        return txt;
    }
}
