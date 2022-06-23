package br.com.tt.snackmachine;

import br.com.tt.snackmachine.model.Produto;

import javax.swing.*;

public class Aplicacao {

    public static void main(String[] args) {
        // cadastrar produtos
        menuCadastroProduto();
        // cadastrar uma Posição (fileira)
        menuCadastroPosicao();

        // atualizar preço do produto
        // buscar produto existente por código
        // atualizar fileira já existente
    }

    private static void menuCadastroProduto(){
        String codigo = JOptionPane.showInputDialog("Informe o código do produto");
        String preco = JOptionPane.showInputDialog("Informe o preço do produto");

        int codigoInt = Integer.parseInt(codigo);
        float precoFloat = Float.parseFloat(preco);

        Produto produto = new Produto(codigoInt, precoFloat);
        String mensagem = "Produto cadastrado com sucesso: "+produto.getDescricao();
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void menuCadastroPosicao(){
    }
}
