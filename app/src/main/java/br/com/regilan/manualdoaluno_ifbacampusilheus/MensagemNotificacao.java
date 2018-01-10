package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

/**
 * Created by Regilan on 16/03/2017.
 */


/* COMO CHAMAR A CLASSE PARA EXIBIR A MENSAGEM - EXEMPLO

 Intent janela = new Intent(getBaseContext(),MainActivity.class);

 MensagemNotificacao mensagemNotificacao = new MensagemNotificacao(getBaseContext(),janela);

  mensagemNotificacao.exibirMensagem("Nome do aplicativo", "Mensagem", R.drawable.logo);



*/

public class MensagemNotificacao {


    private Context contexto;
    private Intent intencao;


    public MensagemNotificacao() {
    }

    public MensagemNotificacao(Context contexto, Intent intencao) {
        this.contexto = contexto;
        this.intencao = intencao;
    }



    public void exibirMensagem(String titulo, String texto)
    {




        NotificationManager gerenciadorMensagens = (NotificationManager) contexto.getSystemService(Context.NOTIFICATION_SERVICE);

        //Intenção para disparar o broadcastt da mensagem

        PendingIntent p = PendingIntent.getActivity(contexto,0,intencao,PendingIntent.FLAG_UPDATE_CURRENT);


        //SOM de notificacao
        Uri somAlarme = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //Cria a notificação
        Notification.Builder mensagem = new Notification.Builder(contexto)
                .setContentIntent(p)
                .setContentTitle(titulo)
                .setContentText(texto)
                //TROCAR PARA O ÍCONE PADRÃO DA APLICACAO
                .setSmallIcon(R.drawable.logo_if)
                .setSound(somAlarme)
                .setAutoCancel(true);

        //Dispara a notificacao

        gerenciadorMensagens.notify(1,mensagem.build());
    }

}
