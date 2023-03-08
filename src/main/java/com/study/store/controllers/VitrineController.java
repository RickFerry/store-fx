package com.study.store.controllers;

import static com.study.store.controllers.ItemController.setIndex;
import static com.study.store.controllers.ItemController.setProduto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.study.store.models.ItensProperty;
import com.study.store.models.Produto;
import com.study.store.models.Vitrine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VitrineController implements Initializable {

	@FXML
	private TextField txtItem;
	@FXML
	private static TableView<ItensProperty> tbView;
	@FXML
	private TableColumn<ItensProperty, String> tbColumnProduto;
	@FXML
	private TableColumn<ItensProperty, Double> tbColumnPreco;

	private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();

	public VitrineController() {
		this.tbView = new TableView<>();
	}

	public static TableView<ItensProperty> getTbView() {
		return tbView;
	}

	set

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		tbColumnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
		tbColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
		Vitrine vitrine = new Vitrine();
		vitrine.addProdutos(new Produto("Bola Topper", 15.00), new Produto("Luvas Umbro", 9.00),
				new Produto("Camisa Esportiva", 40.00), new Produto("Chuteira Nike Mercurial", 199.00),
				new Produto("Caneleira Topper", 10.00));

		for (Produto p : vitrine.getProdutos()) {
			listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));
		}
		tbView.setItems(listItens);

		tbView.getSelectionModel().selectedItemProperty().addListener((ObservableValue, oldValue, newValue) -> {
			setProduto(new Produto(newValue.getProduto(), newValue.getPreco()));
			setIndex(tbView.getSelectionModel().getSelectedIndex());

			try {
				openForms("item");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@FXML
	private void pesquisar() {
		if (!txtItem.getText().equals("")) {
			tbView.setItems(findItens());
		} else {
			tbView.setItems(listItens);
		}
	}

	private ObservableList<ItensProperty> findItens() {
		ObservableList<ItensProperty> itensEncontrados = FXCollections.observableArrayList();
		for (ItensProperty itens : listItens) {
			if (itens.getProduto().contains(txtItem.getText())) {
				itensEncontrados.add(itens);
			}
		}
		return itensEncontrados;
	}

	  public void openForms(String name) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + name +
	  ".fxml"));
	  Stage stage = new Stage();
	  Scene scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	  }
}
