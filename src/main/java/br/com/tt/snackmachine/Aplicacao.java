package br.com.tt.snackmachine;

import br.com.tt.snackmachine.exceptions.PosicaoInvalidaException;
import br.com.tt.snackmachine.model.Maquina;
import br.com.tt.snackmachine.model.Posicao;
import br.com.tt.snackmachine.model.Produto;

import javax.swing.*;
import java.awt.*;

public class Aplicacao {

    private static Maquina maquina = new Maquina((byte) 36); //TODO explicar detalhadamente

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal(){
        JFrame frame = new JFrame("Snak Machine Java!");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 400);

        JButton botaoCadastroProduto = new JButton("Cadastrar Produto/Posição");
        botaoCadastroProduto.addActionListener((e) -> menuCadastroProdutoEPosicao());
        frame.add(botaoCadastroProduto);

//        JButton botaoCadastroPosicao = new JButton("Cadastrar Posicao");
//        botaoCadastroPosicao.addActionListener((e) -> menuCadastroPosicao());
//        frame.add(botaoCadastroPosicao);

        //frame.pack(); // Ajusta o tamanho de acordo com os componentes
        frame.setVisible(true);
    }

    private static void menuCadastroProdutoEPosicao() {
        Produto produto = menuCadastroProduto();
        menuCadastroPosicao(produto);
    }

    private static Produto menuCadastroProduto(){
        String codigo = JOptionPane.showInputDialog("Informe o código do produto");
        String preco = JOptionPane.showInputDialog("Informe o preço do produto");

        //try/catch pra NumberFormatException - relançar uma exceção específica
        int codigoInt = Integer.parseInt(codigo);
        float precoFloat = Float.parseFloat(preco);

        // Código do produto deve ser informado ( > 0 )
        // Preço do produto deve ser informado ( > 0 )

        Produto produto = new Produto(codigoInt, precoFloat);
        String mensagem = "Produto cadastrado com sucesso: "+produto.getDescricao();
        JOptionPane.showMessageDialog(null, mensagem);
        return produto;
    }

    private static void menuCadastroPosicao(Produto produto){
        byte numero = Byte.parseByte(JOptionPane.showInputDialog("Informar a posição (número)"));
        byte quantidade = Byte.parseByte(JOptionPane.showInputDialog("Informar a quantidade de produtos colocados"));

        if(numero < 1 || numero > 12){
//            RuntimeException e = new PosicaoInvalidaException();
//            throw e;
            String mensagem = "Informe posição de 1 a 12. A posição informada foi: "+numero;
            throw new PosicaoInvalidaException(mensagem);
        }

        Posicao posicao = new Posicao(numero, quantidade, produto);
        // TODO validar número da posição
        String mensagem = "Posição cadastrada com sucesso: "+posicao.getDescricao();
        JOptionPane.showMessageDialog(null, mensagem);

        maquina.adicionarPosicao(numero, posicao);
    }
}
