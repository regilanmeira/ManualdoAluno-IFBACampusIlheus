package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RotinasAcademicasActivity extends AppCompatActivity {
    ArrayList<String> rotinasAcademicas;
    ListView lvRotinasAcademicas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotinas_academicas);

        lvRotinasAcademicas = (ListView)findViewById(R.id.lvRotinasAcademicas);

        preencheListaRotinasAcademicas();

        lvRotinasAcademicas.setOnItemClickListener(selecionarItem);

    }


    private void preencheListaRotinasAcademicas()
    {
        rotinasAcademicas = new ArrayList<String>();
        rotinasAcademicas.add("Renovação de matrícula");
        rotinasAcademicas.add("Trancamento de matrícula");
        rotinasAcademicas.add("Avaliação de aprendizado");
        rotinasAcademicas.add("Segunda chamada");
        rotinasAcademicas.add("Frequência para aprovação");
        rotinasAcademicas.add("Revisão de notas");
        rotinasAcademicas.add("Aproveitamento de estudos");
        rotinasAcademicas.add("Perda à vaga");
        rotinasAcademicas.add("Forma de ingresso");
        rotinasAcademicas.add("Conselhos de classe");
        rotinasAcademicas.add("Diploma");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,rotinasAcademicas);
        lvRotinasAcademicas.setAdapter(adapter);

        lvRotinasAcademicas.setOnItemClickListener(selecionarItem);
    }

    AdapterView.OnItemClickListener selecionarItem = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent janela = new Intent(RotinasAcademicasActivity.this,TituloTextoActivityGernerico.class);
            switch(lvRotinasAcademicas.getItemAtPosition(i).toString())
            {
                case"Renovação de matrícula":
                    janela.putExtra("opcao","renovacao");

                    break;
                case"Trancamento de matrícula":
                    janela.putExtra("opcao","trancamento");

                    break;

                case"Avaliação de aprendizado":
                    janela.putExtra("opcao","avaliacao");

                    break;

                case"Segunda chamada":
                    janela.putExtra("opcao","segunda");

                    break;

                case"Frequência para aprovação":
                    janela.putExtra("opcao","frequencia");

                    break;

                case"Revisão de notas":
                    janela.putExtra("opcao","revisao");

                    break;

                case"Aproveitamento de estudos":
                    janela.putExtra("opcao","aproveitamento");

                    break;

                case"Perda à vaga":
                    janela.putExtra("opcao","perda");

                    break;

                case"Forma de ingresso":
                    janela.putExtra("opcao","ingresso");

                    break;

                case"Conselhos de classe":
                    janela.putExtra("opcao","conselho");

                    break;

                case"Diploma":
                    janela.putExtra("opcao","diploma");

                    break;
            }

            startActivity(janela);
        }
    };
}
