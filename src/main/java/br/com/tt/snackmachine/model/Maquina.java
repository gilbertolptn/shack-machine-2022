package br.com.tt.snackmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Maquina {
    private byte capacidade;
    private StatusMaquina status;
    private Posicao[] posicoes = new Posicao[12];
    int pos = 0;

    public void adicionarPosicao(Posicao posicao) {
        posicoes[pos++] = posicao;
    }

    public List<String> getPosicoes() {
        return Arrays.stream(posicoes)
                .filter(Objects::nonNull)
                .map(Posicao::getDescricao)
                .collect(Collectors.toList());
    }
}
