package com.example.storefx;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        produtos.remove(produto);
    }
}
