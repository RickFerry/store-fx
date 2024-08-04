package com.example.storefx;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TransitionsApp extends Application {

    private ImageView imgItem;
    private Button btAddCarrinho;

    @Override
    public void start(Stage stage) throws Exception {
        imgItem = new ImageView(new Image("path/to/image.png"));
        btAddCarrinho = new Button("Adicionar ao Carrinho");

        initComponents();
        initListeners();
        initTransition();
        initTimeline();

        StackPane root = new StackPane(imgItem, btAddCarrinho);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void initComponents() {
        // Inicialização dos componentes (caso necessário)
    }

    private void initListeners() {
        btAddCarrinho.setOnMouseEntered(event -> {
            ScaleTransition transition = new ScaleTransition(Duration.millis(2000), btAddCarrinho);
            transition.setToX(1.5);
            transition.setToY(1.5);
            transition.play();
        });

        btAddCarrinho.setOnMouseExited(event -> {
            ScaleTransition transition = new ScaleTransition(Duration.millis(2000), btAddCarrinho);
            transition.setToX(1.0);
            transition.setToY(1.0);
            transition.play();
        });
    }

    private void initTransition() {
        FadeTransition fTransition = new FadeTransition(Duration.millis(2000), imgItem);
        fTransition.setFromValue(0.0);
        fTransition.setToValue(1.0);

        ScaleTransition sTransition = new ScaleTransition(Duration.millis(2000), btAddCarrinho);
        sTransition.setToX(1.5);
        sTransition.setToY(1.5);
        sTransition.setAutoReverse(true);

        ParallelTransition pTransition = new ParallelTransition();
        pTransition.getChildren().addAll(fTransition, sTransition);
        pTransition.play();
    }

    private void initTimeline() {
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(imgItem.opacityProperty(), 0.0);
        KeyFrame kf = new KeyFrame(Duration.millis(2000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

