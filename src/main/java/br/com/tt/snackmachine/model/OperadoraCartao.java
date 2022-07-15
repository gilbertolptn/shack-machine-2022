package br.com.tt.snackmachine.model;

import br.com.tt.snackmachine.exceptions.PagamentoException;

public class OperadoraCartao {

    public boolean efetuarPagamento(String cartao, String mesAno, String ccv, float preco) {
        return validaCartao(cartao, mesAno, ccv);
    }

    private boolean validaCartao(String cartao, String mesAno, String ccv) {
        try {
            validaDadosCartao(cartao);
            validaDadosCartao(mesAno);
            validaDadosCartao(ccv);
            return true;

        }catch (PagamentoException e){
            e.printStackTrace();
            return false;
        }
    }

    private void validaDadosCartao(String informacao) {
        if(informacao == null || informacao.isBlank()){
            throw new PagamentoException();
        }
    }
}
