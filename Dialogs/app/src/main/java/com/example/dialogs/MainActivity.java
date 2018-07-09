package com.example.dialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton button;
    private AppCompatButton buttonItems;
    private AlertDialog alertDialog;
    private AlertDialog dialogItems;
    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog);
        builder.setMessage("Deseja excluir?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Sim", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = builder.create();

        AlertDialog.Builder builderDialogItems = new AlertDialog.Builder(this, R.style.AlertDialog);
        builderDialogItems.setTitle("Selecione a opçção desejada");
//        builderDialogItems.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
//            }
//        });
        builderDialogItems.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this, items[i] + ":" + b, Toast.LENGTH_SHORT).show();
            }
        });
        builderDialogItems.setPositiveButton("Ok", null);
        builderDialogItems.setNegativeButton("Cancelar", null);

        dialogItems = builderDialogItems.create();


        button = findViewById(R.id.btnAlert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });

        buttonItems = findViewById(R.id.btnItems);
        buttonItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialogItems.show();
            }
        });

    }
}
