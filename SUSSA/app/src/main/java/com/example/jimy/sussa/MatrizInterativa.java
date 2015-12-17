package com.example.jimy.sussa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MatrizInterativa extends AppCompatActivity implements View.OnClickListener{
    LinearLayout llMatrizContainer;
    Button btEditarMatriz, btFullsize;
    FloatingActionButton fbFullSize;
    BDDisciplinas bddisciplinas;
    TextView tvMatrizAtual;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    
    //// TODO: 22/11/15 Criar matriz dinamica 
    //// TODO: 22/11/15 Falta criar uma fragment para legendas
    MatrizBCT_fragment mbct = CurrentUser.matrizBCT_fragment;
    MatrizBCC_fragment mbcc = CurrentUser.matrizBCC_fragment;


    int count = 0;      //indice de referencia ao fragment atual
    int edicao = 0;     //indice de referencia ao modo de acesso da matriz

    //Define GestureScale Parameters
    private float mScale = 1f;
    private ScaleGestureDetector mSGD;
    GestureDetector gestureDetector;
    
    //// TODO: 22/11/15 Bug: Toda vez que muda orientacao, adiciona uma tabela ao Container (faz o scrollview ficar repetindo)
    //// TODO: 22/11/15 Bug: Toda vez que muda orientacao, fragment se reinicia e nao consigo mais editar. Talvez precise tornar a tabela dinamica. Por hora deixar fixo orientacao horizontal no android manifest
    //// TODO: 22/11/15 Problema: Ao trocar o Curso, a matriz atual eh redefinida. Solucao provavel eh tabela dinamica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bddisciplinas = new BDDisciplinas();
        setContentView(R.layout.activity_matrizesint);

        tvMatrizAtual = (TextView) findViewById(R.id.tvMatrizAtual);
        btEditarMatriz = (Button) findViewById(R.id.btEditarMatriz);
        btFullsize = (Button) findViewById(R.id.btFullScreen);
        //fbFullSize = new FloatingActionButton(this);
        llMatrizContainer = (LinearLayout)findViewById(R.id.llMatrizContainer);

        //fbFullSize.show();

        //setando o local onde a matriz BCT vai ser posicionada
        fragmentTransaction.add(R.id.llMatrizContainer, mbct);
        sizeToOverview();
        fragmentTransaction.commit();

        //// TODO: 18/11/15 Mesclar spinner com tvMatrizAtual
        btEditarMatriz.setOnClickListener(this);
        btFullsize.setOnClickListener(this);
        tvMatrizAtual.setOnClickListener(this);
        //fbFullSize.setOnClickListener(this);

        gestureDetector = new GestureDetector(this, new GestureListener());
        mSGD = new ScaleGestureDetector(this, new ScaleListener());
    }


    //resizing methods
    public void sizeToDefault() {
        ScaleAnimation defaultScaleAnimation = new ScaleAnimation(1f, 1f, 1f, 1f);
        defaultScaleAnimation.setDuration(0);
        defaultScaleAnimation.setFillAfter(true);
        llMatrizContainer.startAnimation(defaultScaleAnimation);
    }

    public void sizeToOverview() {
        ScaleAnimation defaultScaleAnimation = new ScaleAnimation(0.5f, 0.5f, 0.5f, 0.5f);
        defaultScaleAnimation.setDuration(0);
        defaultScaleAnimation.setFillAfter(true);
        llMatrizContainer.startAnimation(defaultScaleAnimation);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector)
        {
            if(edicao == 0) {
                float scale = 1 - detector.getScaleFactor();

                float prevScale = mScale;
                mScale += scale;

                if (mScale < 0.1f) // Minimum scale condition:
                    mScale = 0.1f;

                if (mScale > 10f) // Maximum scale condition:
                    mScale = 10f;

                ScaleAnimation scaleAnimation = new ScaleAnimation(1f / prevScale, 1f / mScale, 1f / prevScale, 1f / mScale, detector.getFocusX(), detector.getFocusY());
                scaleAnimation.setDuration(0);
                scaleAnimation.setFillAfter(true);
                llMatrizContainer.startAnimation(scaleAnimation);
            }else{
                Toast.makeText(getApplicationContext(),"Mude para o modo de visualizacao para redimensionar",Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        super.dispatchTouchEvent(event);
        mSGD.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);
        return gestureDetector.onTouchEvent(event);
    }


    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            // double tap fired.
            return true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvMatrizAtual:
                openFragment(getNextMatriz());
                break;
            case R.id.btEditarMatriz:
                //POSSIBILITAR EDICAO
                sizeToDefault();
                btFullsize.setEnabled(false);
                if(edicao == 0) {
                    edicao = 1;
                    btEditarMatriz.setText("VISUALIZAR");
                    switch (count) {
                        case 0:
                            mbct.setButtonsEnabled();
                            break;
                        case 1:
                            //mbcc.setButtonsEnabled();
                            break;
                    }
                }
                //MODO DE LEITURA
                else{
                    edicao = 0;
                    btFullsize.setEnabled(true);
                    btFullsize.performClick();
                    btEditarMatriz.setText("EDITAR MATRIZ");
                    switch (count) {
                        case 0:
                            mbct.setButtonsUnabled();
                            break;
                        case 1:
                            //mbcc.setButtonsUnabled();
                            break;
                    }
                }
                break;
            case R.id.btFullScreen:
                sizeToOverview();
                break;
        }
    }

    //esse metodo eh necessario para toda vez instanciar um novo fragmentManager
    public void openFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.llMatrizContainer, fragment);
        //fragmentTransaction.addToBackStack(null);   //serve para lembrar que o fragment atual sera a tela que aparecera ao apertar 'voltar'
        fragmentTransaction.commit();
    }

    public Fragment getNextMatriz(){
        switch (count){
            case 0:
                tvMatrizAtual.setText("MATRIZ_BCC");
                count++;
                return mbcc;
            case 1:
                tvMatrizAtual.setText("MATRIZ_BCT");
                count--;
                return mbct;
        }
        return mbct;
    }


}
