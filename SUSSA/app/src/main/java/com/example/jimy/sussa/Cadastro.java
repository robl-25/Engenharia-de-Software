package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cadastro extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    
    //// TODO: 10/11/15 Criar Spinner(bottom_menu lateral) com titulo fixo

    private Spinner spCursos;
    private Button bCadastrar;
    public TextView tvTitulo;

    private ArrayAdapter adCursos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        spCursos = (Spinner)findViewById(R.id.spCurso);
        bCadastrar = (Button)findViewById(R.id.bCadastrar);

        bCadastrar.setOnClickListener(this);

        tvTitulo = (TextView)findViewById(R.id.tvTitulo);

        tvTitulo.setGravity(Gravity.CENTER);

        //adCursos = new ArrayAdapter(this,R.layout.my_spinner);
        adCursos = ArrayAdapter.createFromResource(this, R.array.SpinnerCursos,R.layout.my_spinner);
        adCursos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spCursos.setPrompt("Escolha o seu Curso");
        spCursos.setAdapter(adCursos);




        //spCursos.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        Toast.makeText(this,"Voce selecionou "+myText.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.bCadastrar:
               //todo fazer confirmacao de senhas
                startActivity(new Intent(this,Login.class));
                break;
        }

    }


}
