package com.study.store.controllers;

import static com.study.store.controllers.VitrineController.getCarrinho;

import java.net.URL;
import java.util.ResourceBundle;

import com.study.store.models.ItensProperty;
import com.study.store.models.Produto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

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

    private static Stage stage = new Stage();

    private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbColumnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        getCarrinho().getProdutos()
                .forEach(p -> listItens.add(new ItensProperty(p.getProduto(), p.getPreco())));

        tbCarrinhoView.setItems(listItens);

    }

    @FXML
    void excluirItem(ActionEvent event) {
        VitrineController.getCarrinho()
                .removeProduto(new Produto(tbCarrinhoView.getSelectionModel().getSelectedItem().getProduto(),
                        tbCarrinhoView.getSelectionModel().getSelectedItem().getPreco()));
        tbCarrinhoView.getItems().remove(tbCarrinhoView.getSelectionModel().getSelectedItem());
    }

    @FXML
    void voltarVitrine(ActionEvent event) throws InterruptedException {
        /*Stage window = (Stage) btnVoltar.getScene().getWindow();
        window.close();*/

        CarrinhoController.getStage().close();

        ItemController.getStage().close();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CarrinhoController.stage = stage;
    }
}
