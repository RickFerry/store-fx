package com.study.store.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vitrine {

    private static List<Produto> produtos = new ArrayList<>();

    public void addProdutos(Produto... ps) {
        produtos.addAll(Arrays.asList(ps));
    }
    
    public List<Produto> getProdutos(){
        return produtos;
    }
}
