package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarController {

	@FXML
	private TextField nome;

	@FXML
	private TextField email;

	@FXML
	private TextField telefone;

	@FXML
	private Button adicionarBotao;

	@FXML
	private Button cancelarBotao;

	@FXML
	private DatePicker data;

	@FXML
	private TextField id;

	@FXML
	void adicionarBotaoHandler(ActionEvent event) {

	}

	@FXML
	void cancelarBotaoHandler(ActionEvent event) {

		Stage stage = (Stage) cancelarBotao.getScene().getWindow();
		stage.close();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../samples/Sample.FXML"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stageNew = new Stage();
			stageNew.setScene(new Scene(root));
			stageNew.show();
		} catch (Exception e) {
			System.out.println("Erro");
		}

	}
}
