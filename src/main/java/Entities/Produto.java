package Entities;

public class Produto implements ItemCarrinho {
    private String nome;
    private double preco;
    private String descricao;
    private String categoria;

    public Produto(String categoria, String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    // Implementação dos métodos da interface ItemCarrinho
    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    // Restante da implementação da classe Produto
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nome;
    }

}
