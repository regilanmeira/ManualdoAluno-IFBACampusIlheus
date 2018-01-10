package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by Regilan on 29/03/2017.
 */

public class AgendarVerificacaoTarefaReceiver extends BroadcastReceiver{
    public static final String NOME_ACAO = "AGENDAR_VERIFICACAO";
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("Gerou alarme", "Gerou alarme");
        try
        {


            gerarAlarmeVerificarVencimento(context);



        }
        catch (Exception ex)
        {
            Log.d("Exceção",ex.getMessage());
        }

    }


    public void gerarAlarmeVerificarVencimento(Context context)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND,5);

        long tempo= c.getTimeInMillis();

        Intent receptor = new Intent(VerificarTarefaReceiver.NOME_ACAO);

        try
        {
            Alarme.cancelarAlarme(context,receptor);
        }
        catch (Exception ex)
        {

        }
        Alarme.agendarComRepeticao(context,receptor,tempo,43200 * 1000);


    }
}
