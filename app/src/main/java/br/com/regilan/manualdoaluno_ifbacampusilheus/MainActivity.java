package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView lvTarefas;
    Cursor cursorListViewTarefas;
    int _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent janela = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                startActivity(janela);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        lvTarefas = (ListView) findViewById(R.id.lvTarefas);

        preencherListaTarefas();

        lvTarefas.setOnItemClickListener(remover);


        //CHAMADA DO BROADCAST RECEIVER PARA VERIFICAR TAREFAS VENCIDAS

        try {

            this.sendBroadcast(new Intent("AGENDAR_VERIFICACAO"));

            //sendBroadcast(new Intent("VERIFICAR_TAREFA"));
        } catch (Exception ex) {

        }

    }

    protected void onStart() {
        super.onStart();

        preencherListaTarefas();
    }

    void preencherListaTarefas() {

        String[] nomeCampos = new String[]{"tarefa", "data_tarefa_formatada"};
        int[] idElementosLista = new int[]{R.id.tvDescricaoTarefa, R.id.tvDataFormatada};

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tarefas ORDER BY data_tarefa");

            SQLiteComando comando = new SQLiteComando(getBaseContext());

            cursorListViewTarefas = comando.retornar(sql.toString());

            CustomCursorAdapter adapter = new CustomCursorAdapter(getBaseContext(),cursorListViewTarefas);

            lvTarefas.setAdapter(adapter);


        } catch (Exception ex) {

            //Log.d("Exceção", ex.getMessage());
        }

    }

    public void removerTarefa() {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("IFBA Ilhéus");
        dialogo.setMessage("Confirmar a remoção da tarefa??");

        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {

                    StringBuilder sql = new StringBuilder();

                    SQLiteComando comando = new SQLiteComando(getBaseContext());

                    sql.append("DELETE FROM tarefas WHERE _id = '" + _id + "'");


                    if (comando.executar(sql.toString()) == true) {
                        Toast.makeText(getBaseContext(), "Tarefa excluída", Toast.LENGTH_LONG).show();
                        preencherListaTarefas();
                    } else {
                        Toast.makeText(getBaseContext(), "Erro ao remover a tarefa", Toast.LENGTH_LONG).show();
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


    /* ------- ACIONAR BROADCAST PARA VERIFICAR TAREFAS VENCIDAS ------ */
    public void gerarAlarmeVerificarVencimento() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, 5);

        long tempo = c.getTimeInMillis();

        //  Intent receptor = new Intent(VerificarValidadeReceiver.NOME_ACAO);

        //Alarme.agendarComRepeticao(getBaseContext(),receptor,tempo,5 * 1000);

        sendBroadcast(new Intent(VerificarTarefaReceiver.NOME_ACAO));
    }

    AdapterView.OnItemClickListener remover = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            cursorListViewTarefas.moveToPosition(position);

            _id = cursorListViewTarefas.getInt(0);

            removerTarefa();
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent janela = new Intent(MainActivity.this, SobreActivity.class);
            startActivity(janela);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent janela;
        if (id == R.id.nav_rotinas_academicas) {
            janela = new Intent(MainActivity.this, RotinasAcademicasActivity.class);
            startActivity(janela);
        } else if (id == R.id.nav_ramais) {
            janela = new Intent(MainActivity.this, RamaisActivity.class);
            startActivity(janela);
        } else if (id == R.id.nav_docentes) {
            janela = new Intent(MainActivity.this, ProfessoresActivity.class);
            startActivity(janela);
        } else if (id == R.id.nav_historico) {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "historico");
            startActivity(janela);
        } else if (id == R.id.nav_agenda) {
            janela = new Intent(MainActivity.this, WebViewActivity.class);
            startActivity(janela);
        } else if (id == R.id.nav_direito_deveres) {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "direitos_deveres");
            startActivity(janela);
        } else if (id == R.id.nav_departamentos) {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "departamentos");
            startActivity(janela);
        } else if (id == R.id.nav_o_instituto)
        {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "instituto");
            startActivity(janela);
        }else if (id == R.id.nav_assistencia)
        {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "assistencia_estudante");
            startActivity(janela);
        }
        else if (id == R.id.nav_estagios)
        {
            janela = new Intent(MainActivity.this, EstagiosActivity.class);
            startActivity(janela);
        }

        else if (id == R.id.nav_cursos)
        {
            janela = new Intent(MainActivity.this, CursosActivity.class);
            startActivity(janela);
        }
        else if (id== R.id.nav_processo_seletivo)
        {
            janela = new Intent(MainActivity.this, ProcessoSeletivoActivity.class);
            startActivity(janela);
        }
        else if (id== R.id.nav_org_didatica)
        {
            janela = new Intent(MainActivity.this, OrganizacaoDidaticaActivity.class);
            startActivity(janela);
        }
        else if (id==R.id.nav_estrutura_fisica)
        {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "estrutura");
            startActivity(janela);
        }
        else if (id==R.id.nav_fotos)
        {
            janela = new Intent(MainActivity.this, FotosActivity.class);
            startActivity(janela);
        }
        else if (id ==R.id.nav_dicas)
        {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "dicas");
            startActivity(janela);
        }
        else if (id ==R.id.nav_pesquisa_extensao)
        {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "pesquisa");
            startActivity(janela);
        }
        else if (id==R.id.nav_calendario)
        {
            janela = new Intent(MainActivity.this, CalendarioAcademicoActivity.class);
            startActivity(janela);
        }
        else if (id==R.id.nav_horarios)
        {
            janela = new Intent(MainActivity.this, HorarioActivity.class);
            startActivity(janela);
        }
        else if (id==R.id.nav_plano_curso)
        {
            janela = new Intent(MainActivity.this, PlanosDeCursoActivity.class);
            startActivity(janela);
        }
        else if (id ==R.id.nav_mensagem_diretor)
        {
            janela = new Intent(MainActivity.this, TituloTextoActivityGernerico.class);
            janela.putExtra("opcao", "mensagem");
            startActivity(janela);
        }

        else if (id ==R.id.nav_taes)
        {
            janela = new Intent(MainActivity.this, TaesActivity.class);
            startActivity(janela);
        }



        /*
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
