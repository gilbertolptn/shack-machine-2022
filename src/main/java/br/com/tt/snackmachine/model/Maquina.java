package br.com.tt.snackmachine.model;

import br.com.tt.snackmachine.exceptions.MaquinaIndisponivelException;
import br.com.tt.snackmachine.exceptions.PosicaoInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class Maquina {
    private int capacidade;
    private StatusMaquina status;
    private List<Posicao> posicoes;

    public Maquina(int capacidade){
        this.capacidade = capacidade;
        this.status = StatusMaquina.DISPONIVEL;
        this.posicoes = this.posicoesIniciaisSemProduto(capacidade);
    }

    public void alteraStatus(StatusMaquina status){
        this.status = status;
    }

    public void alterarPosicao(int numero, Posicao posicao){
        validaCapacidade(numero);
        posicoes.set(numero, posicao);
    }

    public Produto obtemProdutoPorPosicao(int numero) {
        validaStatus();
        validaCapacidade(numero);
        validaExistenciaProduto(numero);
        return posicoes.get(numero).getProduto();
    }

    private void validaCapacidade(int numero) {
        if(numero > capacidade || numero > posicoes.size()){
            throw new PosicaoInvalidaException("O número informado excede a capacidade da máquina!");
        }
    }

    private void validaExistenciaProduto(int numero) {
        Posicao posicao = posicoes.get(numero);

        if(posicao == null || posicao.getProduto() == null){
            throw new PosicaoInvalidaException("O número informado não possui produtos!");
        }
    }

    private void validaStatus() {
        if(status != StatusMaquina.DISPONIVEL){
            throw new MaquinaIndisponivelException();
        }
    }

    private List<Posicao> posicoesIniciaisSemProduto(int capacidade) {
        List<Posicao> posicoesIniciais = new ArrayList<>();
        for (int i = 0; i < capacidade; i++) {
            posicoesIniciais.add(new Posicao(i, 0, null));
        }
        return posicoesIniciais;
    }
}
