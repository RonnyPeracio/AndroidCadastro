package com.example.avaliacaouc11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Resumo extends AppCompatActivity {

    public Bundle dados;
    public static double total = 0;
    public static double subtotal = 0;
    public static double informatica = 0;
    public static double logistica = 0;
    public static double administracao = 0;
    public static double moda = 0;
    public static double culinaria = 0;
    public static double beleza = 0;

    public static int minfo = 0;
    public static int mlog = 0;
    public static int madm = 0;
    public static int mmoda = 0;
    public static int mculinaria = 0;
    public static int mbeleza = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        Intent it = getIntent();
        this.dados = it.getExtras();

        int marcouInfo = dados.getInt("infor");
        int marcouLogi = dados.getInt("log");
        int marcouAdm = dados.getInt("adm");
        int marcouModa = dados.getInt("moda");
        int marcouCulinaria = dados.getInt("culin");
        int marcouBeleza = dados.getInt("bel");

        if (marcouInfo == 1) {
            minfo = 1;
            CheckBox ck1 = findViewById(R.id.chbInfoS);
            ck1.setChecked(true);
            informatica = 100.00;
            total += informatica;
        } else {
            minfo = 0;
        }
        if (marcouLogi == 1) {
            mlog = 1;
            CheckBox ck2 = findViewById(R.id.chbLogi);
            ck2.setChecked(true);
            logistica = 350.00;
            total += logistica;
        } else {
            mlog = 0;

        }
        if (marcouAdm == 1) {
            madm = 1;
            CheckBox ck3 = findViewById(R.id.chbAdmS);
            ck3.setChecked(true);
            administracao = 300.00;
            total += administracao;
        } else {
            madm = 0;

        }
        if (marcouModa == 1) {
            mmoda = 1;
            CheckBox ck4 = findViewById(R.id.chbModaS);
            ck4.setChecked(true);
            moda = 150.00;
            total += moda;
        } else {
            mmoda = 0;

        }
        if (marcouCulinaria == 1) {
            mculinaria = 1;
            CheckBox ck5 = findViewById(R.id.chbCulinariaS);
            ck5.setChecked(true);
            culinaria = 250.00;
            total += culinaria;
        } else {
            mculinaria = 0;

        }
        if (marcouBeleza == 1) {
            mbeleza = 1;
            CheckBox ck6 = findViewById(R.id.chbBelezaS);
            ck6.setChecked(true);
            beleza = 200.00;
            total += beleza;
        } else {
            mbeleza = 0;
        }
        EditText edtSoma = findViewById(R.id.edtSomaCursos);
        edtSoma.setText(String.valueOf(total));
    }

    public void VerificaCheckBox(View v) {

        int idelemento = v.getId();
        boolean estaCheckado = false;
        total = 0;
        CheckBox ck1 = findViewById(R.id.chbInfoS);
        CheckBox ck2 = findViewById(R.id.chbLogi);
        CheckBox ck4 = findViewById(R.id.chbAdmS);
        CheckBox ck3 = findViewById(R.id.chbModaS);
        CheckBox ck5 = findViewById(R.id.chbCulinariaS);
        CheckBox ck6 = findViewById(R.id.chbBelezaS);

        if (ck1.isChecked()) {
            informatica = 100.00;
            minfo = 1;
            total += informatica;
        } else {
            minfo = 0;
            informatica = 0;
        }
        if (ck2.isChecked()) {
            logistica = 350.00;
            mlog = 1;
            total += logistica;
        } else {
            mlog = 0;
            logistica = 0;
        }
        if (ck3.isChecked()) {
            moda = 150.00;
            madm = 1;
            total += moda;
        } else {
            madm = 0;
            moda = 0;
        }
        if (ck4.isChecked()) {
            administracao = 300.00;
            mmoda = 1;
            total += administracao;
        } else {
            mmoda = 0;
            administracao = 0;
        }
        if (ck5.isChecked()) {
            culinaria = 250.00;
            mculinaria = 1;
            total += culinaria;
        } else {
            mculinaria = 0;
            culinaria = 0;
        }
        if (ck6.isChecked()) {
            beleza = 200.00;
            mbeleza = 1;
            total += beleza;
        } else {
            mbeleza = 0;
            beleza = 0;
        }


        EditText edtSoma = findViewById(R.id.edtSomaCursos);
        edtSoma.setText(String.valueOf(total));

//        Intent it2 = new Intent(Resumo.this, Exibir.class);
//        it2.putExtras(this.dados);
//        startActivity(it2);
    }


    public void proxima(View v) {

        Bundle dados2 = this.dados;
        dados2.putInt("minfo", minfo);
        dados2.putInt("mlog", mlog);
        dados2.putInt("madm", madm);
        dados2.putInt("mmoda", mmoda);
        dados2.putInt("mculin", mculinaria);
        dados2.putInt("mbel", mbeleza);
        dados2.putDouble("total", total);


        Intent it2 = new Intent(Resumo.this, Exibir.class);
        it2.putExtras(dados2);
        startActivity(it2);
    }
}
