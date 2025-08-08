package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ProdutoCollectionRepository {
    private static List<Produto> produtos;

    static {
        produtos = new Vector<>();

        Produto kindle = new Produto();
        kindle.setCategoria(CategoriaCollectionRepository.findById(1L))
                .setNome("Kindle")
                .setDescricao("Leitor de livros digitais")
                .setDataCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(899.00));

        Produto iphone = new Produto();
        iphone.setCategoria(CategoriaCollectionRepository.findById(2L))
                .setNome("IPhone 14 PRO MAX")
                .setDescricao("Smartphone da Apple")
                .setDataCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(129999.99));

        Arrays.asList(kindle, iphone).forEach(ProdutoCollectionRepository::save);
    }

    public static Produto save(Produto produto) {
         if (!produtos.contains(produto)) {
             produto.setId((long) produtos.size() + 1);
             produtos.add(produto);
             return produto;
         }
         return null;
    }

    public static Produto findById(long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Produto> findByCategoria(Categoria categoria) {
        return produtos.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .toList();
    }

    public static List<Produto> findAll() {
        return produtos;
    }

}
