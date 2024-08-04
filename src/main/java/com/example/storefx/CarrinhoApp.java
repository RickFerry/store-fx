package com.example.storefx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class CarrinhoApp extends Application {
    private AnchorPane pane;
    private TableView<VitrineApp.ItensProperty> tbCarrinho;
    private TableColumn<VitrineApp.ItensProperty, String> columnProduto;
    private TableColumn<VitrineApp.ItensProperty, Double> columnPreco;
    private Button btExcluirItem;
    private Button btVoltarVitrine;
    private static Stage stage;
    private static ObservableList<VitrineApp.ItensProperty> listItens = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        tbCarrinho = new TableView<>(listItens);
        columnProduto = new TableColumn<>("Produto");
        columnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        columnPreco = new TableColumn<>("Preço");
        columnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tbCarrinho.getColumns().addAll(columnProduto, columnPreco);
        tbCarrinho.setLayoutX(50);
        tbCarrinho.setLayoutY(50);
        tbCarrinho.setPrefSize(500, 200);

        btExcluirItem = new Button("Excluir Item");
        btExcluirItem.setLayoutX(50);
        btExcluirItem.setLayoutY(270);
        btExcluirItem.setOnAction(event -> {
            Produto produto = new Produto(tbCarrinho.getSelectionModel().getSelectedItem().getProduto(),
                    tbCarrinho.getSelectionModel().getSelectedItem().getPreco());
            VitrineApp.getCarrinho().removeProduto(produto);
            tbCarrinho.getItems().remove(tbCarrinho.getSelectionModel().getSelectedItem());
        });

        btVoltarVitrine = new Button("Voltar à Vitrine");
        btVoltarVitrine.setLayoutX(150);
        btVoltarVitrine.setLayoutY(270);
        btVoltarVitrine.setOnAction(event -> {
            CarrinhoApp.getStage().close();
            ItemApp.getStage().close();
        });

        Button btConfirmarCompra = getButton();

        pane.getChildren().addAll(tbCarrinho, btExcluirItem, btVoltarVitrine, btConfirmarCompra);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        initItens();
    }

    private static Button getButton() {
        Button btConfirmarCompra = new Button("Confirmar Compra");
        btConfirmarCompra.setLayoutX(300);
        btConfirmarCompra.setLayoutY(270);
        btConfirmarCompra.setOnAction(event -> {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
                Platform.runLater(() -> {
                    CarrinhoApp.getStage().close();
                    ItemApp.getStage().close();
                });
            });
            thread.start();
        });
        return btConfirmarCompra;
    }

    private void initItens() {
        for (Produto p : VitrineApp.getCarrinho().getProdutos()) {
            listItens.add(new VitrineApp.ItensProperty(p.getProduto(), p.getPreco()));
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
