package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class RamaisActivity extends AppCompatActivity {
Cursor cursorListView;
    ListView lvRamais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramais);

        lvRamais = (ListView)findViewById(R.id.lvRamais);

        carregarListaRamais();
    }

    public void carregarListaRamais() {
        String[] nomeCampos = new String[]{ "numero", "ramal", "servidor"};
        int[] idViews = new int[]{R.id.tvNumero, R.id.tvRamal, R.id.tvServidor};


        SQLiteComando comandos = new SQLiteComando(getBaseContext());


        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ramais ");
        sql.append("ORDER BY _id");

        cursorListView = comandos.retornar(sql.toString());


        try {
            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                    R.layout.listview_ramais, cursorListView, nomeCampos, idViews, 0);

            lvRamais.setAdapter(adaptador);
        } catch (Exception ex) {
            Log.d("erro",ex.getMessage());
            //Toast.makeText(getBaseContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

}
