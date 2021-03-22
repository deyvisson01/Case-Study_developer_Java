# Case-Study_developer_Java
 
## Sistema criado para monitorar as vendas de funcionários de uma loja.

Projeto de estudo criado para servir de teste de conhecimento em processo de seleção como desenvolvedor full-stack.

Optei por utilizar a escrita em memória para armazenar as informações do sistema.

Cada VENDEDOR terá um uma lista contendo suas informações para controle.

Decidi adotar um formato baseado em códigos para manter uma formatação padrão para a exibição da tabela no terminal e evitar deformações.

Cada vendedor terá um código referente aos seus dados e esses dados poderão ser listados no menu exibido ao usuário.

Modelo de armazenamento de vendedores:
CÓDIGO |           NOME             |      CPF
 1001  | DEYVISSON DE SOUZA BEZERRA | XXX.XXX.XXX.XX  

Modelo de armazenamento de produtos:
CÓDIGO |           DESCRIÇÃO             |      PREÇO
 1001  |       ARROZ BRANCO TIPO 1       |      5,90  

Modelo de armazenamento de vendas:
CÓDIGO DA VENDA | CÓDIGO DO VENDEDOR | CÓDIGO DO PRODUTO | CLIENTE |    DATA    | QUANTIDADE | VALOR FINAL
     0001       |      1001          |       1001        |   XXX   | 17/03/2021 |      10    |    59,00
     
## COMANDOS PARA EXECUÇÂO

### make clean - Limpa os arquivos executáveis

### make update_backup - Restaura o backup dos arquivos

### make server - Compila e executa o servidor python

### make client - Compila e executa o servidor java

### make all - Compila e executa todos os arquivos do projeto
