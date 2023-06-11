# LojaKatchauProjeto

#
Projeto da 3ª Nota da turma P.O.O. 2022-2 
UFPB - DCX - CAMPUS IV
Ministrada por: Ayla Rebouças
Feito por: Felipe Medeiros, João Cardozo, João Lucas, John Pinto
#

Esse é um projeto para ser uma loja virtual de uma loja eletronica chamada "Katchau".

Os as principais funcionalidades são:
  adicionarProdutoAoCarrinho: Adicionar Item ao carrinho chamado.
  removerProdutoDoCarrinho: Remove produto do carrinho que tinha sido adicionado.
  calcularValorTotal: Calcula valor total dos produtos adicionados ao carrinho.
  exibirCarrinho: exibe todos os produtos que foram adicionados ao carrinho.
  filtrarProdutos: é uma funcionalidade em forma de JList que serve para filtrar os produtos baseado na sua categoria.
  exibirDescricaoProduto: ele mostra a descrisção de um produto que já tenha sido definida na base de dados.

As Classes São:
  CarrinhoDeCompras: é um Map que recebe um tipo PRODUTO e um valor inteiro que é a quantidade do produto que vai ser adicionado ao carrinho.
    Funções: 
      adicionarProduto: adiciona um produto.
      removerProduto: remove um produto.
      
  Produto: recebe as informações do produto como: nome, preço, descrição e categoria a que ele pertence.
    Funções: 
      getCategoria: Chama uma categoria.
      getNome: Chama um nome.
      getPreco: Chama um preço.
      getDescrição: Chama uma descrição.
      
  KatchauGui:
    Classe onde é definido a interface e as configurações das funções.
  
