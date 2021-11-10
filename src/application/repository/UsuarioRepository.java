package application.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import application.exceptions.AdicaoFalhouException;
import application.exceptions.BuscaFalhouException;
import application.exceptions.ExclusaoFalhouException;
import application.interfaces.RepositoryInterface;
import application.model.Usuario;

public class UsuarioRepository implements RepositoryInterface {

	@Override
	public void adiciona(Usuario usuario) throws AdicaoFalhouException {
		try {
			FileOutputStream fos = new FileOutputStream("../arquivo.bin", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(usuario);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario buscarPorId(long id) throws BuscaFalhouException {
		List<Usuario> usuarios = buscarTodos();
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() throws BuscaFalhouException {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			Usuario usuario;
			FileInputStream fis = new FileInputStream("../arquivo.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (ois.readObject() != null) {
				usuario = (Usuario) ois.readObject();
				usuarios.add(usuario);
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public void excluir(Usuario usuario) throws ExclusaoFalhouException {
		List<Usuario> usuarios = new ArrayList<>();
		for (Usuario u : usuarios) {
			if (u.getId() == usuario.getId()) {
				usuarios.remove(u);
			}
		}

		for (Usuario u : usuarios) {
			try {
				adiciona(u);
			} catch (AdicaoFalhouException e) {
				e.printStackTrace();
			}
		}
	}

}
