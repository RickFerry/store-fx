package com.example.storefx;

import java.util.Objects;

public class Produto {
    private String produto;
    private double preco;

    public Produto(String produto, double preco) {
        this.produto = produto;
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto1 = (Produto) o;
        return Double.compare(preco, produto1.preco) == 0 && Objects.equals(produto, produto1.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, preco);
    }
}
