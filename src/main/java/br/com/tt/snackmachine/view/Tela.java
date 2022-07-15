package br.com.tt.snackmachine.view;

import br.com.tt.snackmachine.exceptions.NumeroInvalidoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Tela {

    private JFrame frame;

    public Tela() {
        frame = new JFrame("Snak Machine Java!");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 400);
    }

    public void adicionarBotao(String descricao, ActionListener acao) {
        JButton botaoCadastroProduto = new JButton(descricao);
        botaoCadastroProduto.addActionListener(acao);
        frame.add(botaoCadastroProduto);
    }

    public void limparBotoes() {
        frame.getContentPane().removeAll();
    }

    public void exibir() {
        frame.repaint();
        frame.setVisible(true);
    }

    public void mostrarInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void mostrarErro(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Erro ao cadastrar",
                JOptionPane.ERROR_MESSAGE);
    }

    public String perguntar(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public Integer perguntarInt(String message) {
        String retorno = perguntar(message);
        try {
            return Integer.parseInt(retorno);
        }catch (NumberFormatException e){
            throw new NumeroInvalidoException("O número informado deve ser um número inteiro válido!");
        }
    }

    public Float perguntarFloat(String message) {
        String retorno = perguntar(message).replaceAll(",", ".");
        try {
            return Float.parseFloat(retorno);
        }catch (NumberFormatException e){
            throw new NumeroInvalidoException("O número informado deve ser um número decimal válido!");
        }
    }
}
