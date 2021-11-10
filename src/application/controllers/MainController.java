package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import application.model.Usuario;
import application.repository.UsuarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@SuppressWarnings("unused")
	private UsuarioRepository usuarioRepo = new UsuarioRepository();

	@FXML
	private TableView<Usuario> tabela;

	@FXML
	private TableColumn<Usuario, Integer> colunaId;

	@FXML
	private TableColumn<Usuario, String> colunaTitulo, colunaAutor, colunaEditora, colunaData;

	@FXML
	private Button adicionar, excluir, alterar;

	public void adicionarBotaoHandler(ActionEvent event) {
		Stage stage = (Stage) adicionar.getScene().getWindow();
		stage.close();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../samples/Adicionar.FXML"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stageNew = new Stage();
			stageNew.setScene(new Scene(root));
			stageNew.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro!");
		}
	}

	public void excluirBotaoHandler(ActionEvent event) {
		Stage stage = (Stage) adicionar.getScene().getWindow();
		stage.close();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../samples/Excluir.FXML"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stageNew = new Stage();
			stageNew.setScene(new Scene(root));
			stageNew.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro!");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colunaId.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("id"));
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("titulo"));
		colunaAutor.setCellValueFactory(new PropertyValueFactory<Usuario, String>("autor"));
		colunaEditora.setCellValueFactory(new PropertyValueFactory<Usuario, String>("editora"));
		colunaData.setCellValueFactory(new PropertyValueFactory<Usuario, String>("data"));

		try {
			// tabela.getItems().setAll(usuarioRepo.buscarTodos());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro!");
		}
	}
}
