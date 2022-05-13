package com.example.bdnomeidade;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {

    private SQLiteDatabase db;

    //Define as constantes para conexao com o db
    public static final String DB_NAME = "bd_nome_idade";
    public static final int  DB_VERSION = 1;
    public static final String TABELA_N_I = "nome_idade";

    //Define as constantes com os nomes das colunas
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_IDADE = "idade";

    public DataManager(Context context){
        //Cria uma  instancia do nosso helper
        NossoSQliteOpenHelper helper = new NossoSQliteOpenHelper(context);
        //obtem uma base de dados editavel
        db = helper.getWritableDatabase();
    }

    public void inserir(String nome, String idade){


        String query = "INSERT INTO " + TABELA_N_I + "(" + COLUNA_NOME + "," + COLUNA_IDADE +
                ")" + "VALUES (" + "'" + nome + "','" + idade + "');";

        Log.i("insert() = ", query);
        db.execSQL(query);
    }

    //Excluindo registro
    public void deletar(String nome){
        String query = "DELETE FROM "
                + TABELA_N_I + " WHERE "
                + COLUNA_NOME + "= '" + nome + "';";
        Log.i("delete() = ", query);
        db.execSQL(query);
    }

    public Cursor listar(){
        String query = "SELECT * FROM "
                + TABELA_N_I + ";";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public Cursor consulta(String nome){
        String query = "SELECT " + COLUNA_ID + "," + COLUNA_NOME + "," + COLUNA_IDADE + "FROM "
                + TABELA_N_I + "WHERE " + COLUNA_NOME + "= '" + nome + "';";
        Log.i("consulta() = ", query);
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    private class NossoSQliteOpenHelper extends SQLiteOpenHelper{
        //cria o metodo contrutor da classe
        public NossoSQliteOpenHelper (Context context){
            super(context, DB_NAME, null,DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String queryNovaTabela = "CREATE TABLE "
                    + TABELA_N_I + "("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + COLUNA_NOME + "TEXT NOT NULL,"
                    + COLUNA_IDADE + "TEXT NOT NULL)";
            sqLiteDatabase.execSQL(queryNovaTabela);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }


    }
}
