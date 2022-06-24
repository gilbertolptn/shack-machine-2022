package br.com.tt.snackmachine.model;

public class Posicao {
    private byte numero;
    private byte quantidade;
    private Produto produto;

    public Posicao(byte numero, byte quantidade, Produto produto){
        this.numero = numero;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public String getDescricao(){
        return String.format("Posição Nro: %d, Quantidade: %d,\nProduto: %s",
                numero, quantidade, produto.getDescricao());
    }
}
