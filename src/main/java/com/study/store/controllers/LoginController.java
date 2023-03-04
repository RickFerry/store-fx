package com.study.store.controllers;

import static java.lang.System.exit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassWord;
    @FXML
    private Button btnEnter;
    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void closeApp(ActionEvent event) {
        exit(0);
    }

    @FXML
    private void logar(ActionEvent event) throws IOException {
        if (txtLogin.getText().equals("admin") && txtPassWord.getText().equals("casadocodigo")) {
            openForms("vitrine");
        } else {
            JOptionPane.showMessageDialog(null, "Login e/ou senha invalidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openForms(String name) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + name + ".fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
