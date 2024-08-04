package com.example.storefx;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VitrineApp extends Application {
    private AnchorPane pane;
    private TextField txPesquisa;
    private TableView<ItensProperty> tbVitrine;
    private TableColumn<ItensProperty, String> columnProduto;
    private TableColumn<ItensProperty, Double> columnPreco;
    private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();
    private static Carrinho carrinho;
    private static Stage stage;

    public static Carrinho getCarrinho() {
        return carrinho;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VitrineApp.stage = stage;
        initComponents();
        initListeners();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Vitrine - GolFX");
        stage.show();
        initLayout();
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(800, 600);
        txPesquisa = new TextField();
        txPesquisa.setPromptText("Digite o item para pesquisa");
        DropShadow ds = new DropShadow();
        ds.setSpread(0.5);
        ds.setColor(Color.RED);
        txPesquisa.setEffect(ds);
        tbVitrine = new TableView<>();
        tbVitrine.setPrefSize(780, 550);
        columnProduto = new TableColumn<>("Produto");
        columnPreco = new TableColumn<>("Preço");
        tbVitrine.getColumns().addAll(columnProduto, columnPreco);
        pane.getChildren().addAll(txPesquisa, tbVitrine);
        carrinho = new Carrinho();
        columnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        columnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        initItens();
        tbVitrine.setItems(listItens);
        System.out.println("Finalizando initComponents...");
    }

    private void initLayout() {
        txPesquisa.setLayoutX(10);
        txPesquisa.setLayoutY(10);
        tbVitrine.setLayoutX(10);
        tbVitrine.setLayoutY(50);
    }

    private void initListeners() {
        txPesquisa.setOnAction(event -> {
            if (!txPesquisa.getText().isEmpty()) {
                tbVitrine.setItems(findItems());
            } else {
                tbVitrine.setItems(listItens);
            }
        });
    }

    private void initItens() {
        Vitrine v = new Vitrine();
        v.addProdutos(
                new Produto("Bola Topper", 15.00),
                new Produto("Luvas Umbro", 9.00),
                new Produto("Camisa Esportiva", 40.00),
                new Produto("Chuteira Nike Mercurial", 199.00),
                new Produto("Caneleira Topper", 10.00)
        );
        for (Produto p : v.getProdutos()) {
            if (!itensListContainsProduto(listItens, p)) {
                listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));
            }
        }
        tbVitrine.setItems(listItens);
        tbVitrine.getSelectionModel().selectedItemProperty().addListener((value, oldItem, newItem) -> {
            if (newItem != null) {
                ItemApp.setProduto(new Produto(newItem.getProduto(), newItem.getPreco()));
                ItemApp.setIndex(tbVitrine.getSelectionModel().getSelectedIndex());
                try {
                    new ItemApp().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Stage getStage() {
        return stage;
    }

    private boolean itensListContainsProduto(ObservableList<ItensProperty> listItens, Produto p) {
        return listItens.stream().anyMatch(itens -> itens.getProduto().equals(p.getProduto()));
    }

    private ObservableList<ItensProperty> findItems() {
        ObservableList<ItensProperty> itensEncontrados = FXCollections.observableArrayList();
        for (ItensProperty itens : listItens) {
            if (itens.getProduto().contains(txPesquisa.getText())) {
                itensEncontrados.add(itens);
            }
        }
        return itensEncontrados;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class ItensProperty {
        private SimpleStringProperty produto;
        private SimpleDoubleProperty preco;

        public ItensProperty(String produto, double preco) {
            this.produto = new SimpleStringProperty(produto);
            this.preco = new SimpleDoubleProperty(preco);
        }

        public String getProduto() {
            return produto.get();
        }

        public void setProduto(String produto) {
            this.produto.set(produto);
        }

        public double getPreco() {
            return preco.get();
        }

        public void setPreco(double preco) {
            this.preco.set(preco);
        }
    }
}
