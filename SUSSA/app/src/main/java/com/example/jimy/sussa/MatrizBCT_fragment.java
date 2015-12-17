package com.example.jimy.sussa;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jimy on 18/11/15.
 */
public class MatrizBCT_fragment extends Fragment implements View.OnClickListener, View.OnLongClickListener{
    Button btC1, btID1;
    BDDisciplinas bddisciplinas = new BDDisciplinas();
    ArrayList<Button> arrayMateriasBCT;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bct,container,false);
        arrayMateriasBCT = new ArrayList<>();
        setDefaultMatrizBCT();

        return view;

    }

    //Gera matriz BCT Default
    public void setDefaultMatrizBCT(){
        btC1 = (Button)view.findViewById(R.id.btC1);
        btID1 = (Button)view.findViewById(R.id.btID1);

        arrayMateriasBCT.add(btC1);
        arrayMateriasBCT.add(btID1);

        for(Button b: arrayMateriasBCT){
            b.setEnabled(false); //inicia tabela como nao editavel
            b.setTextColor(Color.BLACK);
            b.setOnClickListener(this);
            b.setOnLongClickListener(this);
            b.setText(bddisciplinas.getCursoNome(b.getId()));
            //se existe materias feita, inicia a matriz com as mesmas coloridas
            if(bddisciplinas.isCursado(b.getId())){
                b.setBackgroundColor(Color.rgb(204, 255, 255));
            }
        }
    }

    public void setButtonsEnabled(){
        for (Button b:arrayMateriasBCT) {
            b.setEnabled(true);
        }
    }

    public void setButtonsUnabled(){
        for (Button b:arrayMateriasBCT) {
            b.setEnabled(false);
            b.setTextColor(Color.BLACK);
        }
    }

    @Override
    public void onClick(View v) {
        int clickedButton = v.getId();
        Button b = (Button)v.findViewById(clickedButton);

        if (!bddisciplinas.isCursado(clickedButton)) {
            //// TODO: 17/12/15 Tratar interdisciplinares e eletivas com dialogbox
            if(bddisciplinas.getCursoTipo(clickedButton).equals("Interdisciplinar")) {
                Toast.makeText(getActivity(),"Escolha a disciplina", Toast.LENGTH_SHORT).show();
                bddisciplinas.setCursoNome(clickedButton, "Modelagem Computacional");   //hardcoded
                b.setText("Modelagem Computacional");
            }
            b.setBackgroundColor(Color.rgb(204, 255, 255));
            Toast.makeText(getActivity(), "Passei "+bddisciplinas.getCursoNome(clickedButton)+"!", Toast.LENGTH_SHORT).show();
        } else {
            if(bddisciplinas.getCursoTipo(clickedButton).equals("Interdisciplinar")) {
                bddisciplinas.setCursoNome(clickedButton,"Interdisciplinar");
                b.setText("Interdisciplinar");
            }
            b.setBackgroundColor(Color.rgb(255, 255, 204));
            Toast.makeText(getActivity(), "Nao passei "+bddisciplinas.getCursoNome(clickedButton)+" (desfazer)):", Toast.LENGTH_SHORT).show();
        }
        bddisciplinas.setCursado(clickedButton);    //if true, becomes false. if false becomes true.
//        switch (v.getId()) {
//            case R.id.btC1:
//                if(bddisciplinas.getCursoTipo(b.getId()).equals("Interdisciplinar"))
//                if (!bddisciplinas.isCursado(R.id.btC1)) {
//                btC1.setBackgroundColor(Color.rgb(204, 255, 255));
//                Toast.makeText(getActivity(), "Passei C1!", Toast.LENGTH_SHORT).show();
//                } else {
//                    btC1.setBackgroundColor(Color.rgb(255, 255, 204));
//                    Toast.makeText(getActivity(), "Nao passei C1 (desfazer)):", Toast.LENGTH_SHORT).show();
//                }
//                bddisciplinas.setCursado(R.id.btC1);
//                break;
    }

    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btC1:
                Toast.makeText(getActivity(), "Exibindo informacoes da materia", Toast.LENGTH_SHORT).show();
                }
        return true;
    }

    public float progressoBCT(){
        float progressoBCT = 0;
        for (Button b:arrayMateriasBCT){
            if(b.getBackground().equals(R.color.lightblue)){
                progressoBCT++;
            }
        }
        return (progressoBCT/arrayMateriasBCT.size())*100;
    }
}
