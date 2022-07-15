package br.com.tt.snackmachine.model;

import br.com.tt.snackmachine.exceptions.NumeroInvalidoException;

public class Produto {
    private int codigo;
    private float preco;

    public Produto(int codigo, float preco){
        validarCodigoProduto(codigo);
        validarPrecoProduto(preco);
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getDescricao(){
        return String.format("Codigo: %s, Preço: %.2f", codigo, preco);
    }

    public float getPreco() {
        return preco;
    }

    private void validarCodigoProduto(int codigo) {
        if(codigo <= 0){
            throw new NumeroInvalidoException("O código do produto deve ser um número positivo");
        }
    }

    private void validarPrecoProduto(float preco) {
        if(preco <= 0F){
            throw new NumeroInvalidoException("O preço informado deve ser um número positivo!");
        }
    }
}

