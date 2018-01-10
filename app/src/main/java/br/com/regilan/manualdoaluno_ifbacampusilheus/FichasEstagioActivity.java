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

public class FichasEstagioActivity extends AppCompatActivity {
    ArrayList<String> FichasEstagio;
    ListView lvFichasEstagio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas_estagio);

        lvFichasEstagio = (ListView) findViewById(R.id.lvFichasEstagio);

        preencheListaFichasEstagio();
    }

    private void preencheListaFichasEstagio() {
        FichasEstagio = new ArrayList<String>();
        FichasEstagio.add("Ficha 1: Convênio");
        FichasEstagio.add("Ficha 2: Plano de estágio");
        FichasEstagio.add("Ficha 3: Entrevista");
        FichasEstagio.add("Ficha 4: Avaliação");
        FichasEstagio.add("Ficha 5: Auto avaliação");
        FichasEstagio.add("Relatório de atividades");
        FichasEstagio.add("Modelo de relatório");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, FichasEstagio);
        lvFichasEstagio.setAdapter(adapter);

        lvFichasEstagio.setOnItemClickListener(selecionar);
    }

    AdapterView.OnItemClickListener selecionar = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(FichasEstagioActivity.this);
            dialogo.setTitle("IFBA Ilhéus");
            dialogo.setMessage("Você precisa está conectado a internet para realizar esta operação. Deseja realmente sair do aplictativo e acessar o documento?");

            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);


                    switch (lvFichasEstagio.getItemAtPosition(position).toString()) {
                        case "Ficha 1: Convênio":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/ficha_1_convenio.pdf"));
                            break;
                        case "Ficha 2: Plano de estágio":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/ficha_2_plano_estagio.pdf"));
                            break;

                        case "Ficha 3: Entrevista":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/ficha_3_avaliacao.pdf"));
                            break;

                        case "Ficha 4: Avaliação":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/ficha_4_avaliacao_de_desempenho_do_estagiario.pdf"));
                            break;

                        case "Ficha 5: Auto avaliação":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/ficha_5_auto_avaliacao_do_estagiario.pdf"));
                            break;

                        case "Relatório de atividades":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/relatorio_final_de_estagio.pdf"));
                            break;

                        case "Modelo de relatório":
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.regilan.com.br/app_ifba/modelo_de_relatorio_de_estagio.pdf"));
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
