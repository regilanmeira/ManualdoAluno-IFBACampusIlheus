package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Regilan on 22/03/2017.
 */

public class CustomCursorAdapter extends CursorAdapter {

    TextView tvDataFormatada, tvDescricaoTarefa;

    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.listview_tarefas, parent, false);
        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        tvDataFormatada = (TextView) view.findViewById(R.id.tvDataFormatada);
        tvDescricaoTarefa = (TextView) view.findViewById(R.id.tvDescricaoTarefa);

        tvDataFormatada.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
        tvDescricaoTarefa.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));


        int data_vencimento, data_antecedencia;

        data_vencimento = cursor.getInt(cursor.getColumnIndex(cursor.getColumnName(2)));
        data_antecedencia = cursor.getInt(cursor.getColumnIndex(cursor.getColumnName(5)));


        Notificar(data_vencimento, data_antecedencia);
    }

    public void Notificar(int data_vencimento, int data_antecedencia) {
        try {
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


           if (data_antecedencia <=  dataAtualInteiro)
            {
                tvDataFormatada.setTextColor(Color.parseColor("#379936"));
                tvDescricaoTarefa.setTextColor(Color.parseColor("#379936"));

            }

            if (data_vencimento <= dataAtualInteiro) {
                tvDataFormatada.setTextColor(Color.parseColor("#C91517"));
                tvDescricaoTarefa.setTextColor(Color.parseColor("#C91517"));

            }


        } catch (Exception ex) {
            //Log.d("exceção",ex.getMessage().toString());
        }
    }


}
