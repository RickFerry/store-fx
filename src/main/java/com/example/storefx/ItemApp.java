package com.example.storefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ItemApp extends Application {
    private static Stage stage;
    private static Produto produto;
    private static int index;
    private AnchorPane pane;
    private ImageView imgItem;
    private Label lbDescricao;
    private Label lbPreco;
    private Button btAddCarrinho;
    private static final String[] images = {
            "http://www.sportcenterlopes.com.br/images/250_topper_campo_2009replic.jpg",
            "http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png",
            "http://bimg2.mlstatic.com/camisa-nike-active-importada-manga-longa-esportiva-vermelha_MLB-F-199843960_1391.jpg",
            "http://www.showtenis.com.br/images/_product/979/979112/chuteira-nike-mercurial-glide-3-fg-campo--199fd9.jpg",
            "http://www.katy.com.br/imagens/produtos/original/caneleira-topper-trainning-difusion-13340619502673137.jpg"
    };

    @Override
    public void start(Stage stage) throws Exception {
        ItemApp.stage = stage;
        initComponents();
        initListeners();
        initLayouts();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        imgItem = createImageView();
        lbDescricao = createLabel("Descrição: " + produto.getDescricao());
        lbPreco = createLabel("Preço: " + produto.getPreco());
        btAddCarrinho = createAddCarrinhoButton();

        pane.getChildren().addAll(imgItem, lbDescricao, lbPreco, btAddCarrinho);
    }

    private void initListeners() {
        btAddCarrinho.setOnAction(event -> handleAddCarrinho());
    }

    private void initLayouts() {
        imgItem.setLayoutX(50);
        imgItem.setLayoutY(50);
        lbDescricao.setLayoutX(50);
        lbDescricao.setLayoutY(300);
        lbPreco.setLayoutX(50);
        lbPreco.setLayoutY(330);
        btAddCarrinho.setLayoutX(50);
        btAddCarrinho.setLayoutY(360);
    }

    private ImageView createImageView() {
        imgItem = new ImageView(new Image(images[index]));
        imgItem.setFitWidth(300);
        imgItem.setFitHeight(200);
        imgItem.setEffect(new Reflection());
        return imgItem;
    }

    private Label createLabel(String text) {
        return new Label(text);
    }

    private Button createAddCarrinhoButton() {
        btAddCarrinho = new Button("Adicionar ao Carrinho");
        InnerShadow is = new InnerShadow();
        is.setColor(Color.RED);
        btAddCarrinho.setEffect(is);
        return btAddCarrinho;
    }

    private void handleAddCarrinho() {
        VitrineApp.getCarrinho().addProduto(produto);
        try {
            new CarrinhoApp().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static Produto getProduto() {
        return produto;
    }

    public static void setProduto(Produto produto) {
        ItemApp.produto = produto;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        ItemApp.index = index;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
