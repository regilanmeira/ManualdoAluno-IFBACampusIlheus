package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TaesActivity extends AppCompatActivity {
    ListView lvTaes;
    ArrayList<String> taes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taes);

        lvTaes = (ListView) findViewById(R.id.lvTaes);

       preencheListaTaes();

    }

    private void preencheListaTaes() {
        taes = new ArrayList<String>();
        taes.add("Amilton Santos de Almeida");

        taes.add("Antônio Sergio Silva Nascimento");
        taes.add("Bárbara Tatiana Nunes de Sousa");
        taes.add("Beatriz Rocha");
        taes.add("Carlos Eduardo de Souza");
        taes.add("Carlos Eduardo dos Santos Bomfim");
        taes.add("Cynara Silveira Carvalho");
        taes.add("Elenildo João de Jesus Filho");
        taes.add("Fábio Antônio da Silva Reis");
        taes.add("Girlene Ecio Damasceno Dias");
        taes.add("Gabriel dos Santos Machado");
        taes.add("Graciele Souza Rosário");
        taes.add("Gisele Caires");
        taes.add("Herbert Costa Vaz Santana");
        taes.add("Ianna Cerqueira Santos");
        taes.add("Isânia Nunes Armede");
        taes.add("Iasmael Paixão");
        taes.add("Jefferson Flávio Feitosa Gramacho");
        taes.add("Jaqueline Lourimer");
        taes.add("Jorge Fabrício Lopes dos Santos");
        taes.add("José Guilherme Duplat Alves");
        taes.add("José Luis Figueiredo de Araujo");
        taes.add("Luciene Campos dos Santos");
        taes.add("Marcelo Barbosa de Jesus");
        taes.add("Marcos Roberto Sousa");
        taes.add("Maurício Santos Fernandes");
        taes.add("Marcele Fontes");
        taes.add("Moises Nascimento Santana");
        taes.add("Osires Miguel Barbosa de Andrade");
        taes.add("Raphael Nascimento");
        taes.add("Roberto Pereira de Almeida");
        taes.add("Saul Edgardo Mendez Sanchez Filho");
        taes.add("Suede Mayne Pereira Araújo");
        taes.add("Thalles Cardoso Silva");
        taes.add("Valnêi Pinheiro Souza");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, taes);

        try
        {
            lvTaes.setAdapter(adapter);
        }
        catch (Exception ex)
        {
            Toast.makeText(getBaseContext(),ex.getMessage().toString(),Toast.LENGTH_LONG).show();
        }


    }
}
