package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class EstagiosActivity extends AppCompatActivity {
    TextView tvTexto, tvTitulo;
   Button btAcessarDocumentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estagios);

        tvTexto = (TextView) findViewById(R.id.tvTexto);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);


        tvTitulo.setText(getString(R.string.estagios));
       tvTexto.setText(getString(R.string.estagios_regras));

        btAcessarDocumentos = (Button)findViewById(R.id.btAcessarDocumentos);
        btAcessarDocumentos.setOnClickListener(acessarDocumentos);

    }

View.OnClickListener acessarDocumentos = new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent janela = new Intent(EstagiosActivity.this,FichasEstagioActivity.class);
        startActivity(janela);
    }
};


}
