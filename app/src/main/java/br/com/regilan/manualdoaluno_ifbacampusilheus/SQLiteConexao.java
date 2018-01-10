/* REFERÊNCIA
http://www.devmedia.com.br/criando-um-crud-com-android-studio-e-sqlite/32815 */

/* INCLUIR O NOME DO PACOTE DA APLICAÇÃO - EXEMPLO
 * package com.example.regilan.acessodados; */
package br.com.regilan.manualdoaluno_ifbacampusilheus;

// IMPORTAÇÃO DAS BIBLIOTECAS
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Regilan on 20/06/2016.
 */
public class SQLiteConexao extends SQLiteOpenHelper {
    //TROCAR PELO NOME DO BANCO DE DADOS DA APLICAÇÃO
    private static String nomeDB = "ifba.db";
    //NÚMERO DA VERSÃO, CASO SEJA ALTERADO O SCRIPT, DEVE-SE ALTERAR O NÚMERO DA VERSÃO
    private static int versao = 1;

    //CONSTRUTOR DA CLASSE QUE HERDA O CONSTRUTOR DA CLASSE SQLiteOpenHelper PARA CRIAR O BANCO DE DADOS
    public SQLiteConexao(Context context){
        super(context, nomeDB,null,versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Método onCreate(): é chamado quando a aplicação cria o banco de dados pela primeira vez.
        Nesse método devem ter todas as diretrizes de criação e população inicial do banco.*/

        try {

            //O objeto sql do tipo StringBuilder será usado para constuir a string com o comando SQL
            StringBuilder sql = new StringBuilder();

        /* Aqui criamos o código que será responsável por definir o esquema do banco de dados
        ou seja, criamos as tabelas que compõe o BD - CREATE TABLE ...
		NO ANDROID DEVEMOS TER UMA COLUNA _id EM CADA TABELA
         */
            sql.append("CREATE TABLE IF NOT EXISTS tarefa( " );
            sql.append("_id integer primary key autoincrement, ");
            sql.append("data_tarefa varchar(20), ");
            sql.append("descricao varchar(1000)) ");



            // Executa um comando SQL armazenado no objeto SQL
            db.execSQL(sql.toString());



            sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS ramais ( " );
            sql.append("_id integer primary key autoincrement, ");
            sql.append("ramal varchar(50), ");
            sql.append("numero varchar(5), ");
            sql.append("servidor varchar(20) )");

            // Executa um comando SQL armazenado no objeto SQL
            db.execSQL(sql.toString());

            sql = new StringBuilder();
            sql.append("INSERT INTO ramais(ramal,numero,servidor) values ('CGTI','3101','Hebert | Thales'),");
            sql.append("('Orçamento','3103','Osires'),");
            sql.append("('Financeiro','3104','Luciene'),");
            sql.append("('Financeiro 2','3131','Guilherme Duplat'),");
            sql.append("('Contabilidade','3126','Marcos Roberto'),");
            sql.append("('Diretoria Administrativa','3105','Jorge Fabrício'),");
            sql.append("('Assistente do DAP','3106','Fábio Reis | Késio'),");
            sql.append("('Recursos Humanos','3108','Graciele'),");
            sql.append("('Audiovisual','3109','Lorena Pio'),");
            sql.append("('Portaria','3110',' '),");
            sql.append("('Diretoria Geral','3111','Thiago Barbosa'),");
            sql.append("('Chefia de Gabinete','3112','Elenildo'),");
            sql.append("('Assessoria de Comunicação','3129','Saul'),");
            sql.append("('Diretoria de Ensino','3113','Alan'),");
            sql.append("('Assistente do DE','3114','Maurício | Marcelle'),");
            sql.append("('Psicologia','3115','Carlos Eduardo Bonfim'),");
            sql.append("('Cores','3116','Ismael | Sérgio | Gabriel'),");
            sql.append("('Coordenação de Cursos','3117','Débora'),");
            sql.append("('Assistência Social','3118','Suede'),");
            sql.append("('Coordenação Pedagógica','3119','Girlene | Roberto | Gisele'),");
            sql.append("('Protocolo','3120','Marcelo | Marcos Augusto'),");
            sql.append("('Almoxarifado','3122','José Luiz'),");
            sql.append("('Biblioteca','3123','Valnêi | Cynara | Moisés'),");
            sql.append("('Refeitório','3124','Rita | Isânia'),");
            sql.append("('Sala dos professores','3125',' '),");
            sql.append("('Laboratório de Física e Química','3128','Beatriz | Amilton'),");
            sql.append("('Assistente de Alunos','3130','Ianna | Jeferson | Jaqueline'),");
            sql.append("('Patrimônio','3135','Rafael'),");
            sql.append("('Compras','3107','Carlos Eduardo'),");
            sql.append("('Compras 2','3132','Beatriz'),");
            sql.append("('Coordenação de estágio','3134','Cácio')");




            db.execSQL(sql.toString());


            sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS professores ( " );
            sql.append("_id integer primary key autoincrement, ");
            sql.append("nome varchar(50), ");
            sql.append("area varchar(50), ");
            sql.append("email varchar(50) )");

            // Executa um comando SQL armazenado no objeto SQL
            db.execSQL(sql.toString());

            sql = new StringBuilder();
            sql.append("INSERT INTO professores(nome,area,email) values ('Regilan Meira Silva','Informática','regilan@ifba.edu.br'), ");
            sql.append("('Adriana Oliveira da Silva','História','adriana.silva@ifba.edu.br'), ");
            sql.append("('Alan Oliveira dos Santos','Segurança do Trabalho','alan.oliveira@ifba.edu.br'), ");
            sql.append("('Alexis Martins Teixeira','Matemática','alexis.teixeira@ifba.edu.br'), ");
            sql.append("('Amanda Ferreira da Silva Mendes','Ciências biológicas','amandamendes@ifba.edu.br'), ");
            sql.append("('Ana Gabriela Poll','Espanhol e Inglês','anapoll@ifba.edu.br'), ");
            sql.append("('Annallena de Souza Guedes','Inglês','annallenaguedes@ifba.edu.br'), ");
            sql.append("('Bruna Carmo Rehem','Biologia','brunarehem@ifba.edu.br'), ");
            sql.append("('Bruno de Jesus Santos','Informática','bruno.santos@ifba.edu.br'), ");
            sql.append("('Cacio Costa da Silva','Educação física','cacio.costa@ifba.edu.br'), ");
            sql.append("('Celina Rosa dos Santos','Sociologia','celinarosa@ifba.edu.br'), ");
            sql.append("('Christian Ricardo Silva Passos','Química','christian@ifba.edu.br'), ");
            sql.append("('Cláudia Ribeiro','Educação Física','claudiaribeiro@ifba.edu.br'), ");
            sql.append("('Cristiano Araujo Dias','Educação Física','cristianodias@ifba.edu.br'), ");
            sql.append("('Danilo Almeida Souza','Física','danilos@ifba.edu.br'), ");
            sql.append("('Débora Santa Fé Monteiro de Almeida','Arquitetura e Urbanismo','deborasantafe@hotmail.com'), ");
            sql.append("('Enexandro Nobre Dutra','Matemática','enex1@hotmail.com'), ");
            sql.append("('Esequias Souza de Freitas','Desenho Técnico','esequias@ifba.edu.br'), ");
            sql.append("('Ewerthon Clauber de Jesus Vieira','Sociologia','ewerthon@ifba.edu.br'), ");
            sql.append("('Fabrício Longuinhos Silva','Administração','fabriciolonguinhos@ifba.edu.br'), ");
            sql.append("('Gabriela Freitas Costa','Segurança de trabalho','gabyfreitascosta@hotmail.com'), ");
            sql.append("('Graziela Ninck Dias Menezes','Filosofia','grazielaninck@ifba.edu.br'), ");
            sql.append("('Isabel de Fatima Rodrigues Silva','Artes','isabelrodrigues@ifba.edu.br'), ");
            sql.append("('Jacyara No dos Santos','Inglês','jacyara@ifba.edu.br'), ");
            sql.append("('José Gustavo Cordeiro de Araujo','Informática','josegustavo@ifba.edu.br'), ");
            sql.append("('Juliana Santos Menezes','Português','juliana@ifba.edu.br'), ");
            sql.append("('Karina Neves','Geografia','karina_neves@ifba.edu.br'), ");
            sql.append("('Leandro Silva de Assis','Edificações','leandro.assis@ifba.edu.br'), ");
            sql.append("('Márcia Sousa Maia','Português','marcia.maia@ifba.edu.br'), ");
            sql.append("('Marco Antonio Goes','Introdução a Segurança do Trabalho','marco.goes@ifs.edu.br'), ");
            sql.append("('Maria Isabel Almeida de Oliveira','Física','mariaisabel@ifba.edu.br'), ");
            sql.append("('Maria Olívia Franco','Inglês','maria.olivia@ifba.edu.br'), ");
            sql.append("('Mariluce de Oliveira Silva','Matemática','marimat@ifba.edu.br'), ");
            sql.append("('Mayana Leandra S. dos Santos','Segurança do Trabalho','mayana.santos@ifba.edu.br'), ");
            sql.append("('Philipe Murillo Santana de Carvalho','História','philipe@ifba.edu.br'), ");
            sql.append("('Rodrigo Rizério de Almeida e Pessoa','Filosofia','rodrigopessoa@ifba.edu.br'), ");
            sql.append("('Roseane Santos Batista Leite','Saúde Ocupacional','roseanesbatista@ifba.edu.br'), ");
            sql.append("('Sandra Cunha Gonçalves','Resistência dos Materias','sandracunha@ifba.edu.br'), ");
            sql.append("('Thiago Nascimento Barbosa','Física','thiagonb@ifba.edu.br'), ");
            sql.append("('Uildo Batista Oliveira','Geografia','uildo.batista@ifba.edu.br'), ");
            sql.append("('Urbano Cavalcante da Silva Filho','Português','urbano@ifba.edu.br') ");



            db.execSQL(sql.toString());


             sql = new StringBuilder();


            sql.append("CREATE TABLE IF NOT EXISTS tarefas( " );
            sql.append("_id integer primary key autoincrement, ");
            sql.append("tarefa varchar(60), ");
            sql.append("data_tarefa integer, ");
            sql.append("data_tarefa_formatada varchar(15), ");
            sql.append("ano_tarefa integer, ");
            sql.append("data_antecedencia_tarefa integer, ");
            sql.append("dia_antecedencia_tarefa integer) ");


            db.execSQL(sql.toString());
        }
        catch (Exception ex)
        {
            Log.d("erro",ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*Método onUpgrade(): é o método responsável por atualizar o banco de dados com alguma informação estrutural que tenha sido alterada.
 Ele sempre é chamado quando uma atualização é necessária,
 para não ter nenhum tipo de inconsistência de dados entre o banco existente no aparelho e o novo que a aplicação irá utilizar.*/
        db.execSQL("DROP TABLE IF EXISTS tarefas");
        db.execSQL("DROP TABLE IF EXISTS professores");
        db.execSQL("DROP TABLE IF EXISTS ramais");


        onCreate(db);

    }
}
