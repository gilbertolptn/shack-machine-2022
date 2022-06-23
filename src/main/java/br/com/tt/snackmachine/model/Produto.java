package br.com.tt.snackmachine.model;

public class Produto {
    private int codigo;
    private float preco;

    public Produto(int codigo, float preco){
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getDescricao(){
        return String.format("Codigo: %s, Preço: %.2f", codigo, preco);
    }

}

