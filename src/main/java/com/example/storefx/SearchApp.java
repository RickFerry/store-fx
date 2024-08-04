package com.example.storefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SearchApp extends Application {
    private AnchorPane pane;
    private TextField txPesquisa;

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();

        Scene scene = new Scene(pane, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Efeitos Visuais");
        stage.show();
    }

    private void initComponents() {
        pane = new AnchorPane();

        txPesquisa = new TextField();
        txPesquisa.setLayoutX(50);
        txPesquisa.setLayoutY(100);

        // Aplicando DropShadow com spread e cor
        DropShadow ds = new DropShadow();
        ds.setSpread(0.5);
        ds.setColor(Color.RED);
        txPesquisa.setEffect(ds);

        pane.getChildren().add(txPesquisa);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
