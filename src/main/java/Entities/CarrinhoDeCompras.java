package Entities;
import java.util.ArrayList;
import java.util.List;
public class CarrinhoDeCompras {
    private List<ItemCarrinho> itens;
    private List<Produto> produtos;

    public CarrinhoDeCompras() {
        itens = new ArrayList<>();
        produtos = new ArrayList<>();
    }
    public void adicionarProduto(ItemCarrinho item) {
        itens.add(item);
        produtos.add(item.getProduto());
    }



    public void removerProduto(Produto item) {
        itens.removeIf(i -> i.getProduto().equals(item));
        produtos.remove(item);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ItemCarrinho item : itens) {
            valorTotal += item.getPreco();
        }
        return valorTotal;
    }
    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Itens do carrinho:");
            for (ItemCarrinho item : itens) {
                System.out.println("- " + item.getDescricao() + ": R$" + item.getPreco());
            }
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
