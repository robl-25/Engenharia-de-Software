package com.example.jimy.sussa;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Arquivos extends AppCompatActivity implements View.OnClickListener {

    TextView ola;
    RelativeLayout rl;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquivos);

        rl = (RelativeLayout)findViewById(R.id.rlFiles);

        Button btUpload = (Button)findViewById(R.id.btUpload);
        btUpload.setOnClickListener(this);

        dialog = new AlertDialog.Builder(this).create();
        dialog.setMessage("Selecione o arquivo a ser enviado");
        dialog.setTitle("Upload");
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpload:
                dialog.show();
                break;
        }
    }

}
