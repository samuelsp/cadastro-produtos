package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoCollectionRepositoryTest {

    @BeforeEach
    void setUp() {
        // Reset repository state before each test if needed
    }

    @Test
    void saveShouldNotAddDuplicateProduto() {
        Produto produto = new Produto()
                .setNome("Echo Dot")
                .setDescricao("Smart speaker")
                .setPreco(BigDecimal.valueOf(299.99))
                .setCategoria(CategoriaCollectionRepository.findById(1L));

        ProdutoCollectionRepository.save(produto);
        Produto result = ProdutoCollectionRepository.save(produto);

        assertNull(result);
    }

    @Test
    void saveShouldAddNewProdutoAndAssignId() {
        Produto produto = new Produto()
                .setNome("Alexa")
                .setDescricao("Assistente virtual da Amazon")
                .setPreco(BigDecimal.valueOf(399.99))
                .setCategoria(CategoriaCollectionRepository.findById(1L));

        Produto saved = ProdutoCollectionRepository.save(produto);

        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertTrue(ProdutoCollectionRepository.findAll().contains(saved));
    }

    @Test
    void findByIdShouldReturnProdutoWhenExists() {
        Produto produto = new Produto()
                .setNome("Galaxy S23")
                .setDescricao("Smartphone Samsung")
                .setPreco(BigDecimal.valueOf(4999.99))
                .setCategoria(CategoriaCollectionRepository.findById(2L));

        Produto saved = ProdutoCollectionRepository.save(produto);

        Produto found = ProdutoCollectionRepository.findById(saved.getId());
        assertEquals(saved, found);
    }

    @Test
    void findByIdShouldReturnNullWhenNotExists() {
        Produto found = ProdutoCollectionRepository.findById(999L);
        assertNull(found);
    }

    @Test
    void findByCategoriaShouldReturnProdutosOfGivenCategoria() {
        Categoria categoria = CategoriaCollectionRepository.findById(1L);

        Produto produto1 = new Produto()
                .setNome("Produto A")
                .setDescricao("Descricao A")
                .setPreco(BigDecimal.valueOf(100.00))
                .setCategoria(categoria);

        Produto produto2 = new Produto()
                .setNome("Produto B")
                .setDescricao("Descricao B")
                .setPreco(BigDecimal.valueOf(200.00))
                .setCategoria(categoria);

        ProdutoCollectionRepository.save(produto1);
        ProdutoCollectionRepository.save(produto2);

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);

        assertTrue(produtos.contains(produto1));
        assertTrue(produtos.contains(produto2));
    }

    @Test
    void findByCategoriaShouldReturnEmptyListForUnknownCategoria() {
        Categoria categoria = new Categoria().setId(999L).setNome("Unknown");
        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);
        assertTrue(produtos.isEmpty());
    }

    @Test
    void findAllShouldReturnAllProdutos() {
        List<Produto> produtos = ProdutoCollectionRepository.findAll();
        assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
    }
}