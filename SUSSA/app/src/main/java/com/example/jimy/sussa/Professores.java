package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;


public class Professores extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    SearchView schvBuscarProfessores;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    ProfDestaque_fragment profDestaque_fragment;
    ProfAlfabetica_fragment profAlfabetica_fragment;
    Comentarios_fragment profComent_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professores);

        ToolbarCreator tc = new ToolbarCreator();
        tc.initToolbars(this, "SUSSA_PROFESSORES");

        spinnerCreator(R.id.spProfessores, R.array.SpinnerProfessores);
        spinnerCreator(R.id.spExibirProfessores, R.array.SpinnerExibicao);


        schvBuscarProfessores = (SearchView)findViewById(R.id.schvBuscarProfessores);

        //Verifica o foco do search
//        schvBuscarProfessores.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                Toast.makeText(getApplicationContext(), "Saiu do foco", Toast.LENGTH_SHORT).show();
//                schvBuscarProfessores.setQuery("", false);
//            }
//        });

        profDestaque_fragment = new ProfDestaque_fragment();
        profAlfabetica_fragment = new ProfAlfabetica_fragment();
        profComent_fragment = new Comentarios_fragment();
//
//        //necessita verificar se eh nulo para tratar mudanca de orientacao
//        if(profDestaque_fragment == null) {
//            fragmentTransaction.add(R.id.profFragmentContainer, profAlfabetica_fragment);
//            fragmentTransaction.commit();
//        }
//
//        if(profComent_fragment == null){
//            fragmentTransaction.add(R.id.llCmntProfContainer, profComent_fragment);
//            fragmentTransaction.commit();
//        }

        openFragment(profComent_fragment,R.id.llCmntProfContainer);
    }

    private void spinnerCreator(int spinnerXML,int arrayDados) {
        Spinner spinner = (Spinner)findViewById(spinnerXML);
        spinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter dataAdapter = ArrayAdapter.createFromResource(this, arrayDados, R.layout.my_spinner);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onBackPressed() {
        if (!schvBuscarProfessores.isIconified()) {
            Toast.makeText(getApplicationContext(),"A busca NAO esta expandida",Toast.LENGTH_SHORT).show();
            schvBuscarProfessores.setIconified(true);
        } else {
            Toast.makeText(getApplicationContext(),"A busca esta expandida",Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
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

    //// TODO: 30/11/15 Alterar para listagem por: Alfabetica, Top 5, Aleatorio
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getSelectedItemPosition()){
            case 0:
                Toast.makeText(this, "Selecionado Destaques",Toast.LENGTH_SHORT).show();
                openFragment(profDestaque_fragment, R.id.profFragmentContainer);
                break;
            case 1:
                Toast.makeText(this, "Selecionado Ordem Alfabetica",Toast.LENGTH_SHORT).show();
                openFragment(profAlfabetica_fragment, R.id.profFragmentContainer);
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

    //esse metodo eh necessario para toda vez instanciar um novo fragmentManager
    public void openFragment(Fragment fragment, int container){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.addToBackStack(null);   //serve para lembrar que o fragment atual sera a tela que aparecera ao apertar 'voltar'
        fragmentTransaction.commit();
    }
}
