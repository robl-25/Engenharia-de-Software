package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Professores extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professores);

        ToolbarCreator tc = new ToolbarCreator();
        tc.initToolbars(this, "SUSSA_PROFESSORES");

        Spinner spProfessores = (Spinner)findViewById(R.id.spProfessores);
        spProfessores.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter dataAdapter = ArrayAdapter.createFromResource(this, R.array.SpinnerProfessores,R.layout.my_spinner);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spProfessores.setAdapter(dataAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //startActivity(new Intent(this,Welcome.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.itBusca:
                Toast.makeText(this, "Realize sua busca", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itPreferencias:
                Toast.makeText(this,"Carregando tela de preferencias",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itAjuda:
                Toast.makeText(this,"Abrindo tela de ajuda",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itSair:
                Toast.makeText(this,"Retornando a tela de login..",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Login.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getSelectedItemPosition()){
            case 0:
                Toast.makeText(this, "Selecionado Destaques",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Selecionado Ordem Alfabetica",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Selecionado Disciplinas",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Selecionado Mais votados",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
