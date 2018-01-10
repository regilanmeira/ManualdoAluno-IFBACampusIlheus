package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OrganizacaoDidaticaActivity extends AppCompatActivity {
    TextView tvTexto,tvTitulo;
    Button btAcessarDocumentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizacao_didatica);

        tvTexto = (TextView)findViewById(R.id.tvTexto);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        btAcessarDocumentos = (Button)findViewById(R.id.btAcessarDocumentos);
        btAcessarDocumentos.setOnClickListener(acessarDocumentos);

        tvTitulo.setText(getString(R.string.org_ditatica));
        tvTexto.setText(getString(R.string.org_ditatica_texto));
    }

    View.OnClickListener acessarDocumentos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            AlertDialog.Builder dialogo = new AlertDialog.Builder(OrganizacaoDidaticaActivity.this);
            dialogo.setTitle("IFBA Ilhéus");
            dialogo.setMessage("Você precisa está conectado a internet para realizar esta operação. Deseja realmente sair do aplictativo e acessar o documento?");

            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try {


                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://regilan.com.br/app_ifba/organizacao_didatica.pdf"));


                        try
                        {
                            startActivity(browserIntent);
                        }
                        catch (ActivityNotFoundException e)
                        {

                        }




                    } catch (Exception ex) {
                        //Log.d("exceção", ex.getMessage());
                    }

                }
            });

            dialogo.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });


            AlertDialog alerta;
            alerta = dialogo.create();
            alerta.show();






        }
    };


}
