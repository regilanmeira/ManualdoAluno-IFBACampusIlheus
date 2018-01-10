package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;

public class ProfessoresActivity extends AppCompatActivity {
    Cursor cursorListView;
    ListView lvDocentes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professores);

        lvDocentes = (ListView)findViewById(R.id.lvDocentes);
        lvDocentes.setOnItemClickListener(abrirEmail);

        carregarListaProfessores();
    }

    public void carregarListaProfessores() {
        String[] nomeCampos = new String[]{ "nome", "area", "email"};
        int[] idViews = new int[]{R.id.tvNome, R.id.tvArea, R.id.tvEmail};


        SQLiteComando comandos = new SQLiteComando(getBaseContext());


        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM professores ");
        sql.append("ORDER BY nome");

        cursorListView = comandos.retornar(sql.toString());


        try {
            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                    R.layout.listiview_professores, cursorListView, nomeCampos, idViews, 0);

            lvDocentes.setAdapter(adaptador);
        } catch (Exception ex) {
            Log.d("erro",ex.getMessage());
            //Toast.makeText(getBaseContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

    AdapterView.OnItemClickListener abrirEmail = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            cursorListView.moveToPosition(position);

            final String email =  cursorListView.getString(3);
            AlertDialog.Builder dialogo = new AlertDialog.Builder(ProfessoresActivity.this);
            dialogo.setTitle("IFBA Ilhéus");
            dialogo.setMessage("Você será redirecionado para o aplicativo de e-mail para enviar e-mail ao professor. Deseja realmente sair do aplictativo e acessar o documentos");

            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try {


                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_EMAIL, email);
                        intent.setData(Uri.parse("mailto:" + email));



                        startActivity(Intent.createChooser(intent, "Escolha o aplicativo para enviar o e-mail."));


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
