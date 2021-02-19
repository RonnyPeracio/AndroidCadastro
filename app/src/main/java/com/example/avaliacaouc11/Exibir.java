package com.example.avaliacaouc11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Exibir extends AppCompatActivity {

    public static double informatica = 0;
    public static double logistica = 0;
    public static double administracao = 0;
    public static double moda = 0;
    public static double culinaria = 0;
    public static double beleza = 0;
    public static double total = 0;

    public static int minfo = 0;
    public static int mlog = 0;
    public static int madm = 0;
    public static int mmoda = 0;
    public static int mculinaria = 0;
    public static int mbeleza = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        String cursosselecionados = "";

        Intent it = getIntent();
        Bundle resultado = it.getExtras();

        EditText textoNome = findViewById(R.id.edtExibeNome);
        EditText textoFone = findViewById(R.id.edtExibeFone);
        EditText textoSexo = findViewById(R.id.edtExibeSexo);
        EditText textoEscolaridade = findViewById(R.id.edtExibeEscolaridade);
        EditText textoCursos = findViewById(R.id.edtCursosExibir);
        EditText valorTotal = findViewById(R.id.edtVlrTotalExibir);

       textoNome.setText(resultado.getString("meunome"));
       textoFone.setText(resultado.getString("meufone"));
       textoSexo.setText(resultado.getString("sexo"));
       textoEscolaridade.setText(resultado.getString("escolaridade"));
       valorTotal.setText(String.valueOf(resultado.getDouble("total")));

        if(resultado.getInt("minfo") == 1){
            cursosselecionados += "Informatica, ";
        } else {
            minfo = 0;
        }
        if(resultado.getInt("mlog") == 1){
            cursosselecionados += "Logistica, ";
        } else{
            mlog = 0;
        }
        if(resultado.getInt("madm") == 1){
            cursosselecionados += "Administração, ";
        } else{
            madm = 0;
        }
        if(resultado.getInt("mmoda") == 1){
            cursosselecionados += "Moda, ";
        } else {
            mmoda = 0;
        }
        if(resultado.getInt("mculinaria") == 1){
            cursosselecionados += "Culinaria, ";
        } else {
            mculinaria = 0;
        }
        if(resultado.getInt("mbeleza") == 1){
            cursosselecionados += "Beleza, ";
        } else {
            mbeleza = 0;
        }

        textoCursos.setText(cursosselecionados);

    }
    public void voltar (View v){
        Intent it2 = new Intent(Exibir.this, MainActivity.class);
        startActivity(it2);
    }
}
