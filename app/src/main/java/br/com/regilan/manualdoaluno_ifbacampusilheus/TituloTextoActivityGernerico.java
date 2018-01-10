package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TituloTextoActivityGernerico extends AppCompatActivity {
TextView tvTexto,tvTitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulo_texto_gernerico);

        tvTexto = (TextView)findViewById(R.id.tvTexto);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);

        Intent janela = getIntent();

        String opcao;

        opcao = janela.getStringExtra("opcao");

        switch (opcao)
        {
            case "historico":
                tvTitulo.setText(getString(R.string.historico));
                tvTexto.setText(getString(R.string.historico_texto));
                break;
            case "direitos_deveres":
                tvTitulo.setText(getString(R.string.direitos_deveres));
                tvTexto.setText(getString(R.string.direitos_deveres_regras));
                break;
            case "departamentos":
                tvTitulo.setText(getString(R.string.departamentos));
                tvTexto.setText(getString(R.string.departamentos_textos));
                break;
            case "instituto":
                tvTitulo.setText(getString(R.string.o_instituto));
                tvTexto.setText(getString(R.string.o_instituto_texto));
                break;
            case "assistencia_estudante":
                tvTitulo.setText(getString(R.string.assistencia));
                tvTexto.setText(getString(R.string.assistencia_regras));
                break;
            case "estrutura":
                tvTitulo.setText(getString(R.string.estrutura_fisica));
                tvTexto.setText(getString(R.string.estrutura_fisica_texto));
                break;
            case "renovacao":
                tvTitulo.setText(getString(R.string.renovacao_matricula));
                tvTexto.setText(getString(R.string.renovacao_matricula_regras));
                break;
            case "trancamento":
                tvTitulo.setText(getString(R.string.trancamento_matricula));
                tvTexto.setText(getString(R.string.trancamento_matricula_regras));
                break;
            case "avaliacao":
                tvTitulo.setText(getString(R.string.avaliacao));
                tvTexto.setText(getString(R.string.avaliacao_regras));
                break;
            case "segunda":
                tvTitulo.setText(getString(R.string.segunda_chamada));
                tvTexto.setText(getString(R.string.segunda_chamada_regras));
                break;
            case "frequencia":
                tvTitulo.setText(getString(R.string.frequecia_aprovacao));
                tvTexto.setText(getString(R.string.frequecia_aprovacao_regras));
                break;
            case "revisao":
                tvTitulo.setText(getString(R.string.revisao_notas));
                tvTexto.setText(getString(R.string.revisao_notas_regras));
                break;
            case "aproveitamento":
                tvTitulo.setText(getString(R.string.aproveitamento_estudos));
                tvTexto.setText(getString(R.string.aproveitamento_estudos_regras));
                break;
            case "perda":
                tvTitulo.setText(getString(R.string.perda_vaga));
                tvTexto.setText(getString(R.string.perda_vaga_regras));
                break;
            case "ingresso":
                tvTitulo.setText(getString(R.string.formas_ingresso));
                tvTexto.setText(getString(R.string.formas_ingresso_regras));
                break;
            case "conselho":
                tvTitulo.setText(getString(R.string.conselho_classe));
                tvTexto.setText(getString(R.string.conselho_classe_regras));
                break;
            case "diploma":
                tvTitulo.setText(getString(R.string.diploma));
                tvTexto.setText(getString(R.string.diploma_regras));
                break;
            case "dicas":
            {
                tvTitulo.setText(getString(R.string.dicas));
                tvTexto.setText(getString(R.string.dicas_texto));
                break;
            }
            case "pesquisa":
            {
                tvTitulo.setText(getString(R.string.pesquisa_extensao));
                tvTexto.setText(getString(R.string.pesquisa_extensao_texto));
                break;
            }

            case "mensagem":
            {
                tvTitulo.setText(getString(R.string.mensagem_diretor));
                tvTexto.setText(getString(R.string.mensagem_diretor_texto));
                break;
            }


        }
    }
}
