# Projeto Snack Machine

## Descrição do projeto:

Criar uma aplicação simples para máquinas de Snaks.

# Fluxo de recarga:
- O atendente alimenta a máquina com os produtos até o limite de 12 produtos
- O atendente informa o número do produto, o preço e a quantidade de cada produto.

## Fluxo de atendimento:
- A máquina solicita o número do produto.
- O usuário observa os produtos e preços fixados na máquina.
- O usuário informa o número do produto escolhido.
- A máquina informa o nome do produto e o valor, solicitando o pagamento.
- O usuário informa o número do cartão de crédito, mês/ano e CCV.
- A máquina verifica o número do cartão, realiza a cobrança e dispensa o produto.

### Quais classes vocês localizam?

Produto: numero, preço, quantidade, estado
Maquina: capacidade, produtos, status
Pagamento: estado
Usuario: cartao
Cartao: numero, mesAno, CCV, tipo, bandeira
