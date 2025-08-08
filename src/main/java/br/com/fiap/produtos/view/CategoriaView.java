package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;

import javax.swing.*;

public class CategoriaView {
    static CategoriaCollectionRepository repository;

    public static Categoria select(Categoria categoria) {
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                categoria == null ? 1 : categoria);
        return ret;
    }

    public static Categoria form() {
        String nome = JOptionPane.showInputDialog("Informe o nome da categoria");
        return new Categoria(nome);
    }

    public void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
    }

    public void sucesso(Categoria categoria) {
        System.out.println(categoria);
        JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome().toUpperCase() + " salva com sucesso!");
    }

 }
