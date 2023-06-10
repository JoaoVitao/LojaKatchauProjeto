package GUI;
import Entities.CarrinhoDeCompras;
import Entities.ItemCarrinho;
import Entities.Produto;
import Util.ArquivoUtils;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class KatchauGUI extends JFrame {
    private JList<Produto> listProdutos;
    private CarrinhoDeCompras carrinho;
    private JTextArea textAreaDescricao;
    private JComboBox<String> comboBoxFiltro;
    private List<Produto> todosProdutos; // Lista com todos os produtos disponíveis

    public KatchauGUI() {
        carrinho = new CarrinhoDeCompras();
        todosProdutos = new ArrayList<>(); // Inicializa a lista de todos os produtos

        // Configurações da janela
        setTitle("Katchau! - Loja de Eletrônicos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Componentes
        listProdutos = new JList<>();
        JButton btnAdicionar = new JButton("Adicionar ao carrinho");
        JButton btnRemover = new JButton("Remover do carrinho");
        JButton btnCalcularTotal = new JButton("Finalizar a compra");
        JButton btnVerCarrinho = new JButton("Ver o Carrinho");
        textAreaDescricao = new JTextArea();
        textAreaDescricao.setEditable(false);

        // Inicialização do JComboBox
        comboBoxFiltro = new JComboBox<>();
        comboBoxFiltro.addItem("Todos");
        comboBoxFiltro.addItem("Smartphone");
        comboBoxFiltro.addItem("TV");
        comboBoxFiltro.addItem("Computador");
        comboBoxFiltro.addItem("Console");
        comboBoxFiltro.addItem("Notebook");

        // Painéis
        JPanel painelSuperior = new JPanel(new BorderLayout());
        JPanel painelInferior = new JPanel(new FlowLayout());

        // Adicionando componentes aos painéis
        painelSuperior.add(new JScrollPane(listProdutos), BorderLayout.CENTER);
        painelSuperior.add(btnAdicionar, BorderLayout.SOUTH);
        painelSuperior.add(btnRemover, BorderLayout.NORTH);
        painelSuperior.add(comboBoxFiltro, BorderLayout.EAST);
        painelInferior.add(btnCalcularTotal);
        painelInferior.add(btnVerCarrinho); // Adiciona o botão "Ver Carrinho"

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

        // Ação do botão Ver Carrinho
        btnVerCarrinho.addActionListener(e -> exibirCarrinho());

        // Ação da seleção na JList
        listProdutos.addListSelectionListener(e -> exibirDescricaoProdutoSelecionado());

        // Ação da seleção no JComboBox de filtro
        comboBoxFiltro.addActionListener(e -> aplicarFiltro());
    }

    private void adicionarProduto() {
        Produto produtoSelecionado = listProdutos.getSelectedValue();
        if (produtoSelecionado != null) {
            carrinho.adicionarProduto(produtoSelecionado);
            JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho");

            // Salvar os dados após adicionar o produto
            ArquivoUtils.salvarDados(carrinho.getProdutos(), "produtos.txt");
        }
    }

    private void removerProduto() {
        Produto produtoSelecionado = listProdutos.getSelectedValue();
        if (produtoSelecionado != null) {
            carrinho.removerProduto(produtoSelecionado);
            JOptionPane.showMessageDialog(this, "Produto removido do carrinho!");

            // Salvar os dados após remover o produto
            ArquivoUtils.salvarDados(carrinho.getProdutos(), "produtos.txt");
        }
    }

    private void calcularValorTotal() {
        double valorTotal = carrinho.calcularValorTotal();
        JOptionPane.showMessageDialog(this, "Valor total da compra: R$" + valorTotal + ", Muito Obrigado por comprar com a Katchau!");
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

        if (filtro.equals("Todos")) {
            for (Produto produto : todosProdutos) {
                model.addElement(produto);
            }
        } else {
            for (Produto produto : todosProdutos) {
                if (produto.getCategoria().equals(filtro)) {
                    model.addElement(produto);
                }
            }
        }

        listProdutos.setModel(model);
    }

    private void exibirCarrinho() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho de Compras:\n");

        for (ItemCarrinho item : carrinho.getProdutos()) {
            Produto produto = item.getProduto();
            double preco = produto.getPreco();
            sb.append(produto.getNome()).append(" - R$").append(preco).append("\n");
        }

        sb.append("Total: R$").append(carrinho.calcularValorTotal());

        JOptionPane.showMessageDialog(this, sb.toString(), "Carrinho de Compras", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KatchauGUI katchauGUI = new KatchauGUI();


            // Carregar produtos do arquivo
            List<Produto> produtos = ArquivoUtils.carregarDados("src/main/resources/produtos.txt");
            if (produtos != null) {
                DefaultListModel<Produto> model = new DefaultListModel<>();
                for (Produto produto : produtos) {
                    model.addElement(produto);
                }
                katchauGUI.listProdutos.setModel(model);
                katchauGUI.todosProdutos = produtos; // Atribui a lista de todos os produtos
            }

            katchauGUI.setVisible(true);
        });
    }
}
