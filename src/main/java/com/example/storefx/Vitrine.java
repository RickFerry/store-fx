package com.example.storefx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vitrine {
    private static final List<Produto> produtos = new ArrayList<>();

    public void addProdutos(Produto... produtos) {
        Vitrine.produtos.addAll(Arrays.asList(produtos));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
