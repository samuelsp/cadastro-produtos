package br.com.fiap.produtos;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;
import br.com.fiap.produtos.repository.ProdutoCollectionRepository;
import br.com.fiap.produtos.view.CategoriaView;
import br.com.fiap.produtos.view.Opcao;
import br.com.fiap.produtos.view.OpcaoView;
import br.com.fiap.produtos.view.ProdutoView;

import javax.swing.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Opcao opcao = null;
        do {
            opcao = OpcaoView.select();
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
            }
        } while (opcao != Opcao.ENCERRAR_SISTEMA);

    }

    private static void consultarProdutoPorCategoria() {
        Categoria categoria = CategoriaView.select(null);
        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);
        if (produtos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não encontramos produtos cadastrados para a categoria" + categoria.getNome());
        }
        produtos.forEach(System.out::println);
        produtos.forEach(ProdutoView::show);
    }

    private static void consultarProdutoPorId() {
        Long id = 0l;
        do {
            try {
                id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do produto"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
                System.out.println(e.getMessage());
            }
        } while (id <= 0);

        Produto p = ProdutoCollectionRepository.findById(id);
        if (p != null) {
            ProdutoView.show(p);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }

    private static void alterarProduto() {
        Produto produto = ProdutoView.select();
        ProdutoView.update(produto);
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form();
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form();
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }
}