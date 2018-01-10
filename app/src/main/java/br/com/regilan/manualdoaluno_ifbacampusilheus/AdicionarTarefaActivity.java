package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AdicionarTarefaActivity extends AppCompatActivity {
    EditText txtTarefa,txtNotificarAntecedencia;
    DatePicker txtDataTarefa;
    Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        txtTarefa = (EditText)findViewById(R.id.txtTarefa);
        txtDataTarefa = (DatePicker)findViewById(R.id.txtDataTarefa);
        txtNotificarAntecedencia = (EditText)findViewById(R.id.txtNotificarAntecedencia);

        btSalvar = (Button)findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(salvar);
    }

    View.OnClickListener salvar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                String tarefa;
                StringBuilder data_tarefa = new StringBuilder();
                StringBuilder data_tarefa_formatada = new StringBuilder();



                if (txtTarefa.getText().toString().equals(""))
                {
                    Toast.makeText(getBaseContext(),R.string.msg_preencha_campos,Toast.LENGTH_LONG).show();
                }
                else {
                    tarefa = txtTarefa.getText().toString();

                    int dia, mes, ano,antecedencia;


                    if (txtNotificarAntecedencia.getText().toString().equals(""))
                    {
                        antecedencia = 0;
                    }
                    else
                    {
                        antecedencia = Integer.parseInt(txtNotificarAntecedencia.getText().toString());
                    }

                    dia = txtDataTarefa.getDayOfMonth();
                    mes = txtDataTarefa.getMonth() + 1;

                    ano = txtDataTarefa.getYear();
                    data_tarefa.append(ano);

                    if (dia < 10) {
                        data_tarefa_formatada.append("0" + dia + " de ");
                    } else {
                        data_tarefa_formatada.append(dia + " de ");
                    }


                    switch (mes) {
                        case 1:
                            data_tarefa_formatada.append("jan ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 2:
                            data_tarefa_formatada.append("fev ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 3:
                            data_tarefa_formatada.append("mar ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 4:
                            data_tarefa_formatada.append("abr ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 5:
                            data_tarefa_formatada.append("mai ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 6:
                            data_tarefa_formatada.append("jun ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 7:
                            data_tarefa_formatada.append("jul ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 8:
                            data_tarefa_formatada.append("ago ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 9:
                            data_tarefa_formatada.append("set ");
                            data_tarefa.append("0" + mes);
                            break;
                        case 10:
                            data_tarefa_formatada.append("out ");
                            data_tarefa.append(mes);
                            break;
                        case 11:
                            data_tarefa_formatada.append("nov ");
                            data_tarefa.append(mes);
                            break;
                        case 12:
                            data_tarefa_formatada.append("dez ");
                            data_tarefa.append(mes);
                            break;
                        default:
                            data_tarefa_formatada.append("");
                            break;
                    }

                    if (dia < 10) {
                        data_tarefa.append("0" + dia);
                    } else {
                        data_tarefa.append(dia);
                    }



                    Calendar dataAntecedencia = Calendar.getInstance();
                    dataAntecedencia.set(ano, mes - 1, dia);


                    dataAntecedencia.add(Calendar.DAY_OF_MONTH, antecedencia * -1);


                    int diaAntecedencia, mesAntecedencia, anoAntecedencia;
                    diaAntecedencia = dataAntecedencia.get(Calendar.DAY_OF_MONTH);
                    mesAntecedencia = dataAntecedencia.get(Calendar.MONTH) + 1;
                    anoAntecedencia = dataAntecedencia.get(Calendar.YEAR);

                    StringBuilder dataAntecedenciaFormatada = new StringBuilder();
                    dataAntecedenciaFormatada.append(anoAntecedencia);


                    if (mesAntecedencia < 10) {
                        dataAntecedenciaFormatada.append("0" + mesAntecedencia);
                    } else {
                        dataAntecedenciaFormatada.append(mesAntecedencia);
                    }

                    if (diaAntecedencia < 10) {
                        dataAntecedenciaFormatada.append("0" + diaAntecedencia);
                    } else {
                        dataAntecedenciaFormatada.append(diaAntecedencia);
                    }



                    try {

                        StringBuilder sql = new StringBuilder();

                        SQLiteComando comando = new SQLiteComando(getBaseContext());

                        sql.append("INSERT INTO tarefas(tarefa,data_tarefa,data_tarefa_formatada,ano_tarefa,data_antecedencia_tarefa,dia_antecedencia_tarefa) ");
                        sql.append("VALUES ( ");
                        sql.append("'" + tarefa + "',");
                        sql.append("'" + data_tarefa + "',");
                        sql.append("'" + data_tarefa_formatada + "',");
                        sql.append("'" + ano + "',");
                        sql.append("'" + dataAntecedenciaFormatada + "',");
                        sql.append("'" + antecedencia + "')");


                        if (comando.executar(sql.toString()) == true) {
                            Toast.makeText(getBaseContext(), "Tarefa registrada", Toast.LENGTH_LONG).show();
                            txtTarefa.setText("");
                            txtNotificarAntecedencia.setText("");
                        }
                        else
                        {
                            Toast.makeText(getBaseContext(), "Houve um erro no registro da tarefa. Verifique as informações.", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception ex) {
                        Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
            catch (Exception ex)
            {
                Toast.makeText(getBaseContext(), "Não foi possível inserir a tarefa. Verifique o preenchimento dos campos.", Toast.LENGTH_LONG).show();
            }


        }



    };
}
