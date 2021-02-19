package com.example.avaliacaouc11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static String escolaridade;
    private static String sexo;
    public static int info = 0;
    public static int log = 0;
    public static int adm = 0;
    public static int moda = 0;
    public static int culinaria = 0;
    public static int beleza = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAvancar = findViewById(R.id.btnAvancar);
        btnAvancar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText textoNome = findViewById(R.id.edtNome);
                EditText textoFone = findViewById(R.id.edtTelefone);

                String nome = textoNome.getText().toString();
                String fone = textoFone.getText().toString();

                Bundle dados = new Bundle();
                dados.putString("meunome", nome);
                dados.putString("meufone", fone);
                dados.putString("escolaridade", escolaridade);
                dados.putString("sexo", sexo);
                dados.putInt("infor", info);
                dados.putInt("log", log);
                dados.putInt("adm", adm);
                dados.putInt("moda", moda);
                dados.putInt("culin", culinaria);
                dados.putInt("bel", beleza);

                Intent it = new Intent(MainActivity.this, Resumo.class);
                it.putExtras(dados);
                startActivity(it);
            }
        });

        Spinner spEscola = findViewById(R.id.spnEscolaridade);

        String[] vetorEscola = {"Selecione um Item...", " Ensino Fundamental",
               "Ensino Medio", "Ensino Tecnico", "Ensino Superior", "Pos-Graduado"};
        ArrayList<String> listaEscolar = new ArrayList<>(
                Arrays.asList(vetorEscola)
        );

        ArrayAdapter<String> arrAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, listaEscolar);
        spEscola.setAdapter(arrAdapter);

        spEscola.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                MainActivity.escolaridade = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void verificaCheckbox(View v) {

        boolean estaCheckado = ((CheckBox) v).isChecked();
        int idcomponent = v.getId();

        switch (idcomponent){
            case R.id.chbInfo:
                if (estaCheckado){
                    info = 1;
                } else{
                    info = 0;
                }
        }
        switch (idcomponent){
            case R.id.chbLogi:
                if (estaCheckado){
                    log = 1;
                } else{
                    log = 0;
                }
        }
        switch (idcomponent){
            case R.id.chbAdm:
                if (estaCheckado){
                    adm = 1;
                } else{
                    adm = 0;
                }
        }
        switch (idcomponent){
            case R.id.chbModa:
                if (estaCheckado){
                    moda = 1;
                } else{
                    moda = 0;
                }
        }
        switch (idcomponent){
            case R.id.chbCulinaria:
                if (estaCheckado){
                    culinaria = 1;
                } else{
                    culinaria = 0;
                }
        }
        switch (idcomponent){
            case R.id.chbBeleza:
                if (estaCheckado){
                    beleza = 1;
                } else{
                    beleza = 0;
                }
        }


    }
    public void verificaSexo(View v) {

        boolean estaCheckado = ((RadioButton) v).isChecked();
        int idcomponent = v.getId();

        switch (idcomponent) {

            case R.id.rdbMasc:
                if (estaCheckado) {
                    Toast.makeText(MainActivity.this,
                            "Sexo Masculino",
                            Toast.LENGTH_SHORT).show();
                    sexo = "Masculino";
                }
                break;
            case R.id.rdbFem:
                if (estaCheckado) {
                    Toast.makeText(MainActivity.this,
                            "Sexo Feminino",
                            Toast.LENGTH_SHORT).show();
                    sexo = "Feminino";
                }
                break;
            case R.id.rdbOutro:
                if (estaCheckado) {
                    Toast.makeText(MainActivity.this,
                            "Diferente",
                            Toast.LENGTH_SHORT).show();
                    sexo = "Diferente";
                }
                break;
        }
    }
}

