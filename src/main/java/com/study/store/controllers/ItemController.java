package com.study.store.controllers;

import static com.study.store.controllers.VitrineController.getCarrinho;
import static java.lang.String.valueOf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.study.store.models.Produto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ItemController implements Initializable {

	@Getter@Setter
	private ImageView image;
	private static Produto produto;
	private static int index;
	public static Stage stage = new Stage();
	@FXML


	private static String[] images = { "https://www.amilesportes.com.br/lojas/00044767/prod/054043-1.jpg",
			"https://a-static.mlcdn.com.br/800x560/luva-de-goleiro-umbro-pro-attak-f6-futsal/netshoes/d21-7005-026-01/4bbe934aea5f9e8c6f38da04456bd10d.jpg",
			"https://shoxstore.com.br/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/c/_/c_pia_de_2ic-8979-006_zoom1.jpg.jpg",
			"https://cdn.awsli.com.br/600x450/1842/1842028/produto/190692137/3e3303fc16.jpg",
			"https://static.netshoes.com.br/produtos/caneleira-topper-training-arena-infantil/36/138-4694-036/138-4694-036_zoom1.jpg" };

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAddCarrinho;

	@FXML
	private ImageView imgView;

	@FXML
	private Label lblDescricao;

	@FXML
	private Label lblPreco;

	@FXML
	private Label lblValorPreco;

	@FXML
	private Label lblValorDescricao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblValorDescricao.setText(produto.getProduto());
		lblValorPreco.setText(valueOf(produto.getPreco()));

		imgView.setImage(new Image("https://www.amilesportes.com.br/lojas/00044767/prod/054043-1.jpg"));
		imgView.setImage(new Image(images[index]));
	}

	@FXML
	void adicionarAoCarrinho(ActionEvent event) {
		getCarrinho().addProduto(produto);

		try {
			openForms("carrinho");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Produto getProduto() {
		return produto;
	}

	public static void setProduto(Produto produto) {
		ItemController.produto = produto;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		ItemController.index = index;
	}

	public static String[] getImages() {
		return images;
	}

	public static void setImages(String[] images) {
		ItemController.images = images;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ItemController.stage = stage;
	}

	public void openForms(String name) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + name + ".fxml"));
		Stage screen = new Stage();
		Scene scene = new Scene(root);
		screen.setScene(scene);
		screen.show();
	}
}
