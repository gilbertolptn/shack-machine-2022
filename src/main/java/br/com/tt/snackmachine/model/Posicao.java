package br.com.tt.snackmachine.model;

public class Posicao {
    private int numero;
    private int quantidade;
    private Produto produto;

    public Posicao(int numero, int quantidade, Produto produto){
        this.numero = numero;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public String getDescricao(){
        return String.format("Posição Nro: %d, Quantidade: %d,\nProduto: %s",
                numero, quantidade, produto.getDescricao());
    }

    public Produto getProduto() {
        return produto;
    }
}
