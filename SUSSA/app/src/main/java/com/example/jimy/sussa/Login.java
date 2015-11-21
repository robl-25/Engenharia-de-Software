package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button bEntrar;
    private TextView tvCadastrar;

    EditText etlogin, etsenha;
    UserBuilder userBuilder = new UserBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etlogin = (EditText)findViewById(R.id.etLogin);
        etsenha = (EditText)findViewById(R.id.etSenha);

        bEntrar = (Button)findViewById(R.id.bEntrar);
        tvCadastrar = (TextView)findViewById(R.id.tvCadastrar);

        bEntrar.setOnClickListener(this);
        tvCadastrar.setOnClickListener(this);
    }

    //// TODO: 10/11/15  Criar DB para usuarios/senhas
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bEntrar:
                userBuilder.setUsuario(etlogin.getText().toString(), "", etsenha.getText().toString(), "");
                if(etlogin.getText().toString().equals("")&&etsenha.getText().toString().equals("")){
                    Toast.makeText(this,"Campos Incompletos", Toast.LENGTH_SHORT).show();
                    //// TODO: 11/11/15 Linha para debug, tirar na versao final
                    startActivity(new Intent(this, Profile.class));
                }
                else if((etlogin.getText().toString().equals("aluno")|| etlogin.getText().toString().equals("aluno@unifesp.br"))
                &&(etsenha.getText().toString().equals("unifesp"))
                        ) {
                    Toast.makeText(this,"Redirecionando..", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, Profile.class));
                    //// TODO: 12/11/15 Ver forma melhor para apagar os campos apos o sucesso na autenticacao 
                    etlogin.setText("");
                    etsenha.setText("");
                }else if(etlogin.getText().toString().equals("professor")){
                    Toast.makeText(this,"Professor nao eh autorizado aqui!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Usuario/Senha Incorreta", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvCadastrar:
                startActivity(new Intent(this,Cadastro.class));
        }
    }
}
