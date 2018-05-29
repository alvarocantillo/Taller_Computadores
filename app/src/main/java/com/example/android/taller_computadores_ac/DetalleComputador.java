package com.example.android.taller_computadores_ac;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputador extends AppCompatActivity {
    private Intent i;
    private int foto,marca,ramm,colos,sistema;
    private Bundle bundle;
    private String id;
    private ImageView fot;
    private String[] mar;
    private String[] ram;
    private String[] color;
    private String[] siste;
    private TextView txtmarcaDetalle;
    private TextView txtramDetalle;
    private TextView txtcolorDetalle;
    private TextView txtsisteDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);
        txtmarcaDetalle=findViewById(R.id.txt_marca_detalle);
        txtramDetalle=findViewById(R.id.txt_ram_detalle);
        txtcolorDetalle=findViewById(R.id.txt_color_detalle);
        txtsisteDetalle=findViewById(R.id.txt_sistema_detalle);
        fot=findViewById(R.id.foto);
        mar=getResources().getStringArray(R.array.smarca);
        ram=getResources().getStringArray(R.array.sram);
        color=getResources().getStringArray(R.array.scolor);
        siste=getResources().getStringArray(R.array.ssistema);

        i=getIntent();
        bundle=i.getBundleExtra("datos");
        marca=bundle.getInt("marca");
        ramm=bundle.getInt("ram");
        colos=bundle.getInt("color");
        sistema=bundle.getInt("sistema");
        foto=bundle.getInt("foto");
        id=bundle.getString("id");

        txtmarcaDetalle.setText(mar[marca]);
        txtramDetalle.setText(ram[ramm]);
        txtcolorDetalle.setText(color[colos]);
        txtsisteDetalle.setText(siste[sistema]);
        fot.setImageResource(foto);
    }

    public void eliminar(View v){
        String positivo,negativo;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo=getResources().getString(R.string.positivo);
        negativo=getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador c=new Computador(id);
                c.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        Intent i=new Intent(DetalleComputador.this,Principal.class);
        startActivity(i);
    }
}
