package br.com.fiap.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private LocalDateTime dataCadastro;
    private BigDecimal preco;

    public Produto() {
    }

    public Produto(Long id
                   , String nome
                   , String descricao
                   , Categoria categoria
                   , LocalDateTime dataCadastro
                   , BigDecimal preco)
    {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setCategoria(categoria);
        this.setDataCadastro(dataCadastro);
        this.setPreco(preco);
    }

    public Produto(String nome
                  , String descricao
                  , Categoria categoria
                  , LocalDateTime dataCadastro
                  , BigDecimal preco)
    {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setCategoria(categoria);
        this.setDataCadastro(dataCadastro);
        this.setPreco(preco);
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Produto setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    @Override
    public String toString() {
        return this.getNome().toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
