package com.study.store.controllers;

import static com.study.store.controllers.VitrineController.getCarrinho;

import java.net.URL;
import java.util.ResourceBundle;

import com.study.store.models.ItensProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CarrinhoController implements Initializable {

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnExcluirItem;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<ItensProperty> tbCarrinhoView = new TableView<>();

    @FXML
    private TableColumn<ItensProperty, Double> tbColumnPreco;

    @FXML
    private TableColumn<ItensProperty, String> tbColumnProduto;

    private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbColumnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        getCarrinho().getProdutos()
                .forEach(p -> listItens.add(new ItensProperty(p.getProduto(), p.getPreco())));

        tbCarrinhoView.setItems(listItens);

    }
}
