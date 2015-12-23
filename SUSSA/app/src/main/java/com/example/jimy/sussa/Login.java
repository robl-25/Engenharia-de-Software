package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button bEntrar;
    private TextView tvCadastrar;
    private TextView tvTitulo;

    BDManager bdManager = new BDManager();
    EditText etlogin, etsenha;
    String login, senha;
    UserBuilder userBuilder = new UserBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        etlogin = (EditText)findViewById(R.id.etLogin);
        etsenha = (EditText)findViewById(R.id.etSenha);
        bEntrar = (Button)findViewById(R.id.bEntrar);
        tvCadastrar = (TextView)findViewById(R.id.tvCadastrar);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);


        tvTitulo.setGravity(Gravity.CENTER);

        bEntrar.setOnClickListener(this);
        tvCadastrar.setOnClickListener(this);
    }

    //// TODO: 10/11/15  Criar DB para usuarios/senhas
    @Override
    public void onClick(View v) {
        login = etlogin.getText().toString();
        senha = etsenha.getText().toString();

        switch (v.getId()) {
            case R.id.bEntrar:
                userBuilder.setCurrentUser(login,"","", senha, "",null,null); //limpeza ao retornar a activity
                authentication(login,senha);
                //authentication2(login,senha);  //autenticacao hardcoded (sem bd)
                break;
            case R.id.tvCadastrar:
                Toast.makeText(this,"Redirecionando a tela de cadastro", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Cadastro.class));
        }
    }

    private void authentication(String login, String senha){
        if(login.equals("professor")){
            Toast.makeText(this,"Professor nao eh autorizado aqui!", Toast.LENGTH_SHORT).show();
        }
        else if(!BDUsers.hashUsers.containsKey(login))
            Toast.makeText(this,"Usuario nao encontrado",Toast.LENGTH_SHORT).show();
        else {
            User u = BDUsers.hashUsers.get(login);
            if(u.getSenha().equals(senha)){
                userBuilder.setCurrentUser(u.getNome(),u.getUsuario(),u.getEmail(),u.getSenha(),u.getCurso(),u.getMatrizBCT_fragment(),u.getMatrizBCC_fragment());
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
            else    Toast.makeText(this,"Senha incorreta",Toast.LENGTH_SHORT).show();
        }
    }

    private void authentication2(String login, String senha) {
        if(login.equals("")&&senha.equals("")){
            Toast.makeText(this, "Campos Incompletos", Toast.LENGTH_SHORT).show();
            //// TODO: 11/11/15 Linha para debug, tirar na versao final
            startActivity(new Intent(this, Profile.class));
        }
        else if((login.equals("aluno")|| login.equals("aluno@unifesp.br"))
        &&(senha.equals("unifesp"))
                ) {
            Toast.makeText(this,"Redirecionando..", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Profile.class));
            //// TODO: 12/11/15 Ver forma melhor para apagar os campos apos o sucesso na autenticacao
            etlogin.setText("");
            etsenha.setText("");
        }else if(login.equals("professor")){
            Toast.makeText(this,"Professor nao eh autorizado aqui!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Usuario/Senha Incorreta", Toast.LENGTH_SHORT).show();
        }
    }
}
