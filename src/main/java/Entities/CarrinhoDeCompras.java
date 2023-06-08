package Entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private static List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        itens = new ArrayList<>();
    }

    public static void adicionarProduto(ItemCarrinho item) {
        itens.add(item);
    }

    public void removerProduto(ItemCarrinho item) {
        itens.remove(item);
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

}
