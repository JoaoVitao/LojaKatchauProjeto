package GUI;

import Entities.CarrinhoDeCompras;
import Entities.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KatchauGUI extends JFrame {
    private JList<Produto> listProdutos;
    private CarrinhoDeCompras carrinho;
    private JTextArea textAreaDescricao;
    private JComboBox<String> comboBoxFiltro;

    public KatchauGUI() {
        carrinho = new CarrinhoDeCompras();

        // Configurações da janela
        setTitle("Katchau! - Loja de Eletrônicos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Componentes
        listProdutos = new JList<>();
        JButton btnAdicionar = new JButton("Adicionar ao carrinho");
        JButton btnRemover = new JButton("Remover do carrinho");
        JButton btnCalcularTotal = new JButton("Finalizar compra");
        textAreaDescricao = new JTextArea();
        textAreaDescricao.setEditable(false);
        comboBoxFiltro = new JComboBox<>();

        // Painéis
        JPanel painelSuperior = new JPanel(new BorderLayout());
        JPanel painelInferior = new JPanel(new FlowLayout());

        // Adicionando componentes aos painéis
        painelSuperior.add(new JScrollPane(listProdutos), BorderLayout.CENTER);
        painelSuperior.add(btnAdicionar, BorderLayout.SOUTH);
        painelSuperior.add(btnRemover, BorderLayout.NORTH);
        painelSuperior.add(comboBoxFiltro, BorderLayout.EAST);
        painelInferior.add(btnCalcularTotal);

        // Adicionando painéis à janela
        add(painelSuperior, BorderLayout.NORTH);
        add(textAreaDescricao, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        // Ação do botão Adicionar Produto
        btnAdicionar.addActionListener(e -> adicionarProduto());

        // Ação do botão Remover Produto
        btnRemover.addActionListener(e -> removerProduto());

        // Ação do botão Calcular Valor Total
        btnCalcularTotal.addActionListener(e -> calcularValorTotal());

        // Ação da seleção na JList
        listProdutos.addListSelectionListener(e -> exibirDescricaoProdutoSelecionado());

        // Ação da seleção no JComboBox de filtro
        comboBoxFiltro.addActionListener(e -> aplicarFiltro());
    }

    private void adicionarProduto() {
        Produto produtoSelecionado = listProdutos.getSelectedValue();
        if (produtoSelecionado != null) {
            carrinho.adicionarProduto(produtoSelecionado);
            JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho!");
        }
    }

    private void removerProduto() {
        Produto produtoSelecionado = listProdutos.getSelectedValue();
        if (produtoSelecionado != null) {
            carrinho.removerProduto(produtoSelecionado);
            JOptionPane.showMessageDialog(this, "Produto removido do carrinho!");
        }
    }

    private void calcularValorTotal() {
        double valorTotal = carrinho.calcularValorTotal();
        JOptionPane.showMessageDialog(this, "Valor total da compra: R$" + valorTotal);
    }

    private void exibirDescricaoProdutoSelecionado() {
        Produto produtoSelecionado = listProdutos.getSelectedValue();
        if (produtoSelecionado != null) {
            textAreaDescricao.setText(produtoSelecionado.getDescricao());
        } else {
            textAreaDescricao.setText("");
        }
    }

    private void aplicarFiltro() {
        String filtro = (String) comboBoxFiltro.getSelectedItem();

        DefaultListModel<Produto> model = new DefaultListModel<>();

        for (int i = 0; i < listProdutos.getModel().getSize(); i++) {
            Produto produto = listProdutos.getModel().getElementAt(i);
            if (produto.getCategoria().equals(filtro) || filtro.equals("Todos")) {
                model.addElement(produto);
            }
        }

        listProdutos.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KatchauGUI katchauGUI = new KatchauGUI();

            // Adicionar produtos pré-estabelecidos na JList
            Produto produto1 = new Produto("Smartphone", "Produto 1", 10.0, "Descrição do Produto 1");
            Produto produto2 = new Produto("TV", "Produto 2", 20.0, "Descrição do Produto 2");
            Produto produto3 = new Produto("Desktop", "Produto 3", 30.0, "Descrição do Produto 3");
            Produto produto4 = new Produto("Tablet", "Produto 4", 40.0, "Descrição do Produto 4");
            Produto produto5 = new Produto("Console", "Produto 5", 50.0, "Descrição do Produto 5");
            Produto produto6 = new Produto("Headset", "Produto 6", 60.0, "Descrição do Produto 6");
            Produto produto7 = new Produto("Notebook", "Produto 7", 70.0, "Descrição do Produto 7");

            DefaultListModel<Produto> model = new DefaultListModel<>();
            model.addElement(produto1);
            model.addElement(produto2);
            model.addElement(produto3);
            model.addElement(produto4);
            model.addElement(produto5);
            model.addElement(produto6);
            model.addElement(produto7);

            katchauGUI.listProdutos.setModel(model);

            // Adicionar opções de filtro ao JComboBox
            katchauGUI.comboBoxFiltro.addItem("Todos");
            katchauGUI.comboBoxFiltro.addItem("Smartphone");
            katchauGUI.comboBoxFiltro.addItem("TV");
            katchauGUI.comboBoxFiltro.addItem("Desktop");
            katchauGUI.comboBoxFiltro.addItem("Tablet");
            katchauGUI.comboBoxFiltro.addItem("Console");
            katchauGUI.comboBoxFiltro.addItem("Headset");
            katchauGUI.comboBoxFiltro.addItem("Notebook");

            katchauGUI.setVisible(true);
        });
    }
}
