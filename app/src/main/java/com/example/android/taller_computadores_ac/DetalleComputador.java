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
    private String tipo,marca,ramm,colos,sistema;
    private Bundle bundle;
    private String id;
    private int foto;
    private ImageView fot;
    private TextView txtmarcaDetalle;
    private TextView txtramDetalle;
    private TextView txtcolorDetalle;
    private TextView txttipoDetalle;
    private TextView txtsisteDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);
        txtmarcaDetalle=findViewById(R.id.txt_marca_detalle);
        txtramDetalle=findViewById(R.id.txt_ram_detalle);
        txtcolorDetalle=findViewById(R.id.txt_color_detalle);
        txttipoDetalle=findViewById(R.id.txt_tipo_detalle);
        txtsisteDetalle=findViewById(R.id.txt_sistema_detalle);
        fot=findViewById(R.id.foto);


        i=getIntent();
        bundle=i.getBundleExtra("datos");
        marca=bundle.getString("marca");
        ramm=bundle.getString("ram");
        colos=bundle.getString("color");
        tipo=bundle.getString("tipo");
        sistema=bundle.getString("sistema");
        foto=bundle.getInt("foto");
        id=bundle.getString("id");

        txtmarcaDetalle.setText(marca);
        txtramDetalle.setText(ramm);
        txtcolorDetalle.setText(colos);
        txttipoDetalle.setText(tipo);
        txtsisteDetalle.setText(sistema);
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
