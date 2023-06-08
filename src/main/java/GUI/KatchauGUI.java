package GUI;

import Entities.CarrinhoDeCompras;
import Entities.Produto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KatchauGUI extends JFrame {
    private CarrinhoDeCompras carrinho;
    private DefaultListModel<String> listaItens;

    public KatchauGUI() {
        carrinho = new CarrinhoDeCompras();
        listaItens = new DefaultListModel<>();

        // Configurações da janela
        setTitle("Katchau! - Loja de Eletrônicos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Componentes
        JList<String> listaProdutos = new JList<>(listaItens);
        JButton btnAdicionar = new JButton("Adicionar Produto");
        JButton btnCalcularTotal = new JButton("Calcular Valor Total");

        // Painéis
        JPanel painelSuperior = new JPanel(new FlowLayout());
        JPanel painelInferior = new JPanel(new FlowLayout());

        // Adicionando componentes aos painéis
        painelSuperior.add(btnAdicionar);
        painelInferior.add(btnCalcularTotal);

        // Adicionando painéis à janela
        add(new JScrollPane(listaProdutos), BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);
        add(painelInferior, BorderLayout.SOUTH);

        // Ação do botão Adicionar Produto
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        // Ação do botão Calcular Valor Total
        btnCalcularTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValorTotal();
            }
        });
    }

    private void adicionarProduto() {
        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
        String precoStr = JOptionPane.showInputDialog("Digite o preço do produto:");
        double preco = Double.parseDouble(precoStr);

        Produto produto = new Produto(nome, preco, "");
        carrinho.adicionarProduto(produto);
        listaItens.addElement(produto.getNome() + ": R$" + produto.getPreco());
    }

    private void calcularValorTotal() {
        double valorTotal = carrinho.calcularValorTotal();
        JOptionPane.showMessageDialog(this, "Valor total da compra: R$" + valorTotal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                KatchauGUI katchauGUI = new KatchauGUI();
                katchauGUI.setVisible(true);
            }
        });
    }
}

