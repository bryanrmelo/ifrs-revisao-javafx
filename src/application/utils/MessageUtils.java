package application.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageUtils {

	public static void mostrarAlert(String mensagem, AlertType tipo) {
		Alert alerta = new Alert(tipo);
		if (AlertType.ERROR.equals(tipo)) {
			alerta.setTitle("ERRO");
			alerta.setContentText(mensagem + " falhou!");
		} else
			if (AlertType.INFORMATION.equals(tipo)) {
				alerta.setTitle("AVISO");
				alerta.setContentText(mensagem + " concluiu!");
			}

		alerta.showAndWait();
	}

}
