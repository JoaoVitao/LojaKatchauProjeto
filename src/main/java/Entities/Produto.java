package Entities;
public class Produto implements ItemCarrinho {
    private String categoria;
    private String nome;
    private double preco;
    private String descricao;




    public Produto(String categoria, String nome,double preco, String descricao) {
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
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


        @Override
        public Produto getProduto() {
            return this;
        }


    // Restante da implementação da classe Produto
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nome;
    }

}
