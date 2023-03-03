package com.study.store.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carrinho {

    private static List<Produto> produtos = new ArrayList<>();

    public void addProduto(Produto... ps) {
        produtos.addAll(Arrays.asList(ps));
    }
    
    public List<Produto> getProdutos(){
        return produtos;
    }
}
