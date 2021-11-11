package application.controllers;

import application.exceptions.AdicaoFalhouException;
import application.model.Usuario;
import application.repository.UsuarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarController {

	private Usuario usuario = new Usuario();

	private UsuarioRepository usuarioRepo = new UsuarioRepository();

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
		try {
			usuarioRepo.adiciona(usuario);
			Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
			dialogoAviso.setTitle("AVISO");
			dialogoAviso.setContentText("Adi��o conclu�da com sucesso!");
			dialogoAviso.showAndWait();
		} catch (AdicaoFalhouException e) {
			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
			dialogoAviso.setTitle("ERRO");
			dialogoAviso.setContentText("Adi��o falhou!");
			dialogoAviso.showAndWait();
		}
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
