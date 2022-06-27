package br.com.tt.snackmachine.model;

public class Maquina {
    private byte capacidade;
    private StatusMaquina status;
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
