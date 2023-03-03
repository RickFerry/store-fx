package com.study.store.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ItensProperty {
    private SimpleStringProperty produto;
    private SimpleDoubleProperty preco;
    
    public ItensProperty(String produto, Double preco){
        this.produto = new SimpleStringProperty(produto);
        this.preco = new SimpleDoubleProperty(preco);
    }
    
    public String getProduto(){
        return produto.get();
    }
    
    public void setProduto(String produto){
        this.produto.set(produto);
    }
    
    public double getPreco(){
        return preco.get();
    }
    
    public void setPreco(double preco){
        this.preco.set(preco);
    }
}
