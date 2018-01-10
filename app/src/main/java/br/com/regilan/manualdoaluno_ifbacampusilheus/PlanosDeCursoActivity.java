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

public class PlanosDeCursoActivity extends AppCompatActivity {
    ArrayList<String> cursos;
    ListView lvCursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planos_de_curso);

        lvCursos = (ListView)findViewById(R.id.lvCursos);

        preencheCursos();
    }

    private void preencheCursos() {
        cursos = new ArrayList<String>();
        cursos.add("Integrado em Informática");
        cursos.add("Subsequente em Informática");
        cursos.add("Integrado em Seg. Trabalho");
        cursos.add("Subsequente em Seg. Trabalho");
        cursos.add("Integrado em Edificações");
        cursos.add("Subsequente em Edificações");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cursos);
        lvCursos.setAdapter(adapter);

        lvCursos.setOnItemClickListener(selecionarItem);
    }

    AdapterView.OnItemClickListener selecionarItem = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(PlanosDeCursoActivity.this);
            dialogo.setTitle("IFBA Ilhéus");
            dialogo.setMessage("Você precisa está conectado a internet para realizar esta operação. Deseja realmente sair do aplictativo e acessar o documento?");

            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);


                    switch (lvCursos.getItemAtPosition(position).toString()) {
                        case "Integrado em Informática":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/matriz_informatica_integrado.pdf"));
                            break;
                        case "Subsequente em Informática":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/matriz_informatica_subsequente.pdf"));
                            break;
                        case "Integrado em Seg. Trabalho":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/matriz_seguranca_integrado.pdf"));
                            break;
                        case "Subsequente em Seg. Trabalho":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/matriz_seguranca_subsequente.pdf"));
                            break;
                        case "Integrado em Edificações":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/matriz_edificacoes_integrado.pdf"));
                            break;
                        case "Subsequente em Edificações":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/matriz_edificacoes_subsequente.pdf"));
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
