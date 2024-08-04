package com.example.storefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class LoginApp extends Application {
    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar;
    private Button btSair;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("login.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login - GolFX");
        stage.show();
        initLayout();
        LoginApp.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.getStyleClass().add("pane");
        txLogin = new TextField();
        txLogin.setPromptText("Digite seu login...");
        txSenha = new PasswordField();
        txSenha.setPromptText("Digite aqui sua senha");
        btEntrar = new Button("Entrar");
        btSair = new Button("Sair");
        pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
    }

    private void initLayout() {
        txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
        txLogin.setLayoutY(50);
        txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
        txSenha.setLayoutY(100);
        btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
        btEntrar.setLayoutY(150);
        btEntrar.getStyleClass().add("btEntrar");
        btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
        btSair.setLayoutY(200);
        btSair.getStyleClass().add("btSair");
    }

    private void initListeners() {
        btSair.setOnAction(event -> fecharAplicacao());
        btEntrar.setOnAction(event -> logar());
    }

    private void fecharAplicacao() {
        System.exit(0);
    }

    private void logar() {
        if (txLogin.getText().equals("") && txSenha.getText().equals("")) {
            try {
                new VitrineApp().start(new Stage());
                LoginApp.getStage().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(
                    null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
