package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HorarioActivity extends AppCompatActivity {
    ArrayList<String> modalidades;
    ListView lvModalidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        lvModalidade = (ListView)findViewById(R.id.lvModalidade);

        preencheModalidade();
    }

    private void preencheModalidade() {
        modalidades = new ArrayList<String>();
        modalidades.add("Integrado");
        modalidades.add("Subsequente");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, modalidades);
        lvModalidade.setAdapter(adapter);

        lvModalidade.setOnItemClickListener(selecionarItem);
    }

    AdapterView.OnItemClickListener selecionarItem = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int  position, long id) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(HorarioActivity.this);
            dialogo.setTitle("IFBA Ilhéus");
            dialogo.setMessage("Você precisa está conectado a internet para realizar esta operação. Deseja realmente sair do aplictativo e acessar o documento?");

            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);


                    switch (lvModalidade.getItemAtPosition(position).toString()) {
                        case "Integrado":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/horario_integrado.pdf"));
                            break;
                        case "Subsequente":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/horario_subsequente.pdf"));
                            break;

                    }


                    try {
                        startActivity(browserIntent);
                    } catch (Exception ex) {

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
