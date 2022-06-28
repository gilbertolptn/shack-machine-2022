package br.com.tt.snackmachine.model;

public class Maquina {
    private byte capacidade;
    private StatusMaquina status;

    /*
    Trocar array por uma lista que acharem mais adequada.

    TODO: corrigir
     */
    private Posicao[] posicoes;

    public Maquina(byte capacidade){
        this.capacidade = capacidade;
        this.posicoes = new Posicao[capacidade];
        this.status = StatusMaquina.DISPONIVEL;
    }

    public void adicionarPosicao(byte numero, Posicao novaPosicao){
        posicoes[numero] = novaPosicao;
    }
}
