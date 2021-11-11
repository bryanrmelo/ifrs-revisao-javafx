package application.controllers;

import application.exceptions.BuscaFalhouException;
import application.exceptions.ExclusaoFalhouException;
import application.repository.UsuarioRepository;
import application.utils.MessageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExcluirController {

	private UsuarioRepository usuarioRepo = new UsuarioRepository();

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
		try {
			usuarioRepo.excluir(usuarioRepo.buscarPorId(Long.parseLong(id.getText())));
			MessageUtils.mostrarAlert("Exclusão", AlertType.INFORMATION);
		} catch (ExclusaoFalhouException e) {
			MessageUtils.mostrarAlert("Exclusão", AlertType.ERROR);
		} catch (BuscaFalhouException e) {
			MessageUtils.mostrarAlert("Busca", AlertType.ERROR);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
