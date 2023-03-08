package com.study.store.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Carrinho {

    private static List<Produto> produtos = new ArrayList<>();

    public void addProduto(Produto... ps) {
        produtos.addAll(Arrays.asList(ps));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void removeProduto(Produto p) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getProduto().equals(p.getProduto()) && Objects.equals(produto.getPreco(), p.getPreco())) {
                iterator.remove();
            }
        }
    }
}
