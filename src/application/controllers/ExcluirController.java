package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExcluirController {

	@FXML
	private TextField id;

	@FXML
	private Button botaoExcluir, botaoCancelar;

	@FXML
	void botaoCancelarHandler(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../samples/Sample.FXML"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stageNew = new Stage();
			stageNew.setScene(new Scene(root));
			stageNew.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
	}

	@FXML
	void botaoExcluirHandler(ActionEvent event) {

	}

}
