package com.luan.appanotacoes.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "applista";
    private static final int VERSAO_BANCO = 2;

    public Conexao(Context contexto){
        super(contexto, NOME_BANCO, null, VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS anotacoes (            " +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  " +
                "anotacao TEXT NOT NULL)                           " );



            }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antiga, int nova){
        if (antiga == 1 && nova == 2){
            sqLiteDatabase.execSQL("DROP TABLE anotacoes");
            onCreate(sqLiteDatabase);
    }
    }

}
