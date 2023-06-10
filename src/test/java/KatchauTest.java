import entities.CarrinhoDeCompras;
import entities.Produto;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class KatchauTest {

    private CarrinhoDeCompras carrinho;

    @Before
    public void setUp() {
        carrinho = new CarrinhoDeCompras();
    }

    @Test
    public void testAdicionarProdutoAoCarrinho() {
        Produto produto1 = new Produto("Eletrônicos", "Smartphone", 999.99, "Smartphone top de linha");
        Produto produto2 = new Produto("Eletrônicos", "TV", 1499.99, "TV de alta resolução");

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);

        Map<Produto, Integer> itensCarrinho = carrinho.getCarrinho();
        assertEquals(2, itensCarrinho.get(produto1).intValue());
        assertEquals(1, itensCarrinho.get(produto2).intValue());
    }

    @Test
    public void testRemoverProdutoDoCarrinho() {
        Produto produto1 = new Produto("Eletrônicos", "Smartphone", 999.99, "Smartphone top de linha");
        Produto produto2 = new Produto("Eletrônicos", "TV", 1499.99, "TV de alta resolução");

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);

        carrinho.removerProduto(produto1);

        Map<Produto, Integer> itensCarrinho = carrinho.getCarrinho();
        assertEquals(1, itensCarrinho.get(produto1).intValue());
        assertEquals(1, itensCarrinho.get(produto2).intValue());
    }


}
