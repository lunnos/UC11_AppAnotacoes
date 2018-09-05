package com.luan.appanotacoes.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.luan.appanotacoes.model.Anotacao;

public class AnotacaoDAO {

    public static void inserir(Context contexto, Anotacao anotacao){
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("titulo", anotacao.getTitulo());
        valores.put("anotacao", anotacao.getAnotacao());

        banco.insert("anotacoes", null, valores);
    }


}
