package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by Regilan on 21/03/2017.
 */

public class VerificarTarefaReceiver extends BroadcastReceiver {
    public static final String NOME_ACAO = "VERIFICAR_TAREFA";
    Cursor dadosTarefa;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("Gerou alarme", "Gerou alarme");
        gerarNotificacaoValidade(context);
    }

    public void gerarNotificacaoValidade(Context context) {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tarefas ORDER BY data_tarefa");

            SQLiteComando comando = new SQLiteComando(context);

            dadosTarefa = comando.retornar(sql.toString());

            //Pegar e formatar data atual
            Calendar dataAtual = Calendar.getInstance();
            int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
            int mesAtual = dataAtual.get(Calendar.MONTH);
            mesAtual += 1;
            int anoAtual = dataAtual.get(Calendar.YEAR);

            String dataAtualTexto;

            if (diaAtual < 10) {

                if (mesAtual < 10) {
                    dataAtualTexto = String.valueOf(anoAtual) + "0" + String.valueOf(mesAtual) + "0" + String.valueOf(diaAtual);
                } else {
                    dataAtualTexto = String.valueOf(anoAtual) + String.valueOf(mesAtual) + "0" + String.valueOf(diaAtual);
                }
            } else {
                if (mesAtual < 10) {
                    dataAtualTexto = String.valueOf(anoAtual) + "0" + String.valueOf(mesAtual) + String.valueOf(diaAtual);
                } else {
                    dataAtualTexto = String.valueOf(anoAtual) + String.valueOf(mesAtual) + String.valueOf(diaAtual);
                }
            }

            int dataAtualInteiro = Integer.parseInt(dataAtualTexto);

            for (int i = 0; i < dadosTarefa.getCount(); i++) {
                dadosTarefa.moveToPosition(i);

                if ((dadosTarefa.getInt(2) <= dataAtualInteiro) || (dadosTarefa.getInt(5) <= dataAtualInteiro)) {

                    Intent janela = new Intent(context, MainActivity.class);

                    MensagemNotificacao notificacao = new MensagemNotificacao(context, janela);
                    notificacao.exibirMensagem("IFBA Ilhéus", "Você tem tarefas vencidas ou sinalizadas para notificação.");
                }
            }
        } catch (Exception ex) {

        }
    }
}
