package br.com.tt.snackmachine;

import br.com.tt.snackmachine.model.*;
import br.com.tt.snackmachine.view.Tela;

public class Aplicacao {

    private static Tela tela = new Tela();
    private static Maquina maquina = new Maquina(36);
    private static OperadoraCartao operadoraCartao = new OperadoraCartao();

    public static void main(String[] args) {
        modoEscolha();
    }

    private static void modoEscolha() {
        tela.limparBotoes();
        tela.adicionarBotao("Modo Operador", (e) -> modoOperador());
        tela.adicionarBotao("Modo Usuário", (e) -> modoUsuario());
        tela.exibir();
    }

    private static void modoOperador() {
        maquina.alteraStatus(StatusMaquina.MANUTENCAO);

        tela.limparBotoes();
        tela.adicionarBotao("Ir para o Menu Principal", (e) -> modoEscolha());
        tela.adicionarBotao("Alterar Produto/Posição", (e) -> menuCadastroOperador());
        tela.exibir();
    }

    private static void modoUsuario() {
        maquina.alteraStatus(StatusMaquina.DISPONIVEL);

        tela.limparBotoes();
        tela.adicionarBotao("Ir para o Menu Principal", (e) -> modoEscolha());
        tela.adicionarBotao("Realizar Compra", (e) -> menuCompraUsuario());
        tela.exibir();
    }

    private static void menuCadastroOperador() {
        try {
            menuCadastroProduto();
        }catch (RuntimeException e) {
            e.printStackTrace();
            tela.mostrarErro(e.getMessage());
        }
    }

    private static void menuCompraUsuario() {
        try {
            menuCompra();
        }catch (RuntimeException e) {
            e.printStackTrace();
            tela.mostrarErro(e.getMessage());
        }
    }

    private static void menuCompra() {
        Integer posicao = tela.perguntarInt("Informe o número do produto na máquina (posição)");

        Produto produto = maquina.obtemProdutoPorPosicao(posicao);
        tela.mostrarInfo(String.format("Produto escolhido: %s", produto.getDescricao()));

        String cartao = tela.perguntar("Informe o número do Cartão de Crédito");
        String mesAno = tela.perguntar("Informe o mês/ano do Cartão de Crédito");
        String ccv = tela.perguntar("Informe o CCV do Cartão de Crédito");

        boolean pagamentoAceito = operadoraCartao.efetuarPagamento(cartao, mesAno, ccv, produto.getPreco());

        if(pagamentoAceito){
            tela.mostrarInfo("Pagamento aceito! Retire seu produto no local indicado!");
        }else {
            tela.mostrarInfo("Erro ao processar seu pagamento! Tente novamente!");
        }
    }

    private static void menuCadastroProduto(){
        Integer codigo = tela.perguntarInt("Informe o código do produto");
        Float preco = tela.perguntarFloat("Informe o preço do produto");
        Produto produto = new Produto(codigo, preco);

        int numero = tela.perguntarInt("Informar a posição");
        int quantidade = tela.perguntarInt("Informar a quantidade de produtos colocados");

        Posicao posicao = new Posicao(numero, quantidade, produto);

        maquina.alterarPosicao(numero, posicao);

        tela.mostrarInfo("Posição alterada com sucesso: "+posicao.getDescricao());
    }
}
