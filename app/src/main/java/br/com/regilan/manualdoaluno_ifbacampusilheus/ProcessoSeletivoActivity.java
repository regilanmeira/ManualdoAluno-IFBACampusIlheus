package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProcessoSeletivoActivity extends AppCompatActivity {
    TextView tvTexto,tvTitulo;
    Button btAcessarDocumentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processo_seletivo);

        tvTexto = (TextView)findViewById(R.id.tvTexto);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        btAcessarDocumentos = (Button)findViewById(R.id.btAcessarDocumentos);
        btAcessarDocumentos.setOnClickListener(acessarDocumentos);

        tvTitulo.setText(getString(R.string.processo_seletivo));
        tvTexto.setText(getString(R.string.processo_seletivo_texto));
    }

    View.OnClickListener acessarDocumentos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            AlertDialog.Builder dialogo = new AlertDialog.Builder(ProcessoSeletivoActivity.this);
            dialogo.setTitle("IFBA Ilhéus");
            dialogo.setMessage("Você será redirecionado para uma página web onde encontrará informações do processo seletivo atual. Deseja realmente sair do aplictativo e acessar os documentos?");

            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try {


                        Uri uri = Uri.parse("https://portal.ifba.edu.br/processoseletivo2018/pagina-inicial");

                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                        startActivity(intent);


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
