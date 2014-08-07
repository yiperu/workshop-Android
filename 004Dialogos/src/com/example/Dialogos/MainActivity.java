package com.example.Dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    final CharSequence[] colores = {"Blue", "Red", "Yellow", "Purple"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //showDialogo();
        //showDialogoConLista();
        showDialogoConCheckBox();
    }

    private void showDialogo(){

        new AlertDialog.Builder(this)
                .setTitle("Titulo del Dialogo")
                .setMessage("Cerrar la Aplicacion")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("====> Dialogo", "No quires cerrar el dialogo");
                    }
                }).show();
    }

    private void showDialogoConLista(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pincha un Color");
        builder.setItems(colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), colores[i],Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alerta = builder.create();
        alerta.show();
    }

    private void showDialogoConCheckBox(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pincha un Color");
        builder.setSingleChoiceItems(colores,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), colores[i],Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alerta = builder.create();
        alerta.show();
    }


}
