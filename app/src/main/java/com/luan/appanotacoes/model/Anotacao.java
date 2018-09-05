package com.luan.appanotacoes.model;

public class Anotacao {

    private int id;
    private String titulo;
    private String anotacao;

    public Anotacao(){

    }

    public Anotacao(String anotacao){
        this.id = id;
        this.titulo = titulo;
        this.anotacao = anotacao;

    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getAnotacao() {return anotacao;}

    public void setAnotacao(String anotacao) {this.anotacao = anotacao;}

    public String toString(){return anotacao;}

    }
