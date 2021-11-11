package application.repository;

import java.io.EOFException;
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
			List<Usuario> usuarios = buscarTodos();
			usuarios.add(usuario);
			FileOutputStream fos = new FileOutputStream("resources/arquivo.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(usuarios);
			oos.close();
		} catch (IOException | BuscaFalhouException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(List<Usuario> usuarios) throws AdicaoFalhouException {
		try {
			FileOutputStream fos = new FileOutputStream("resources/arquivo.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(usuarios);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() throws BuscaFalhouException {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/arquivo.bin"));
			List<Usuario> readObject = (ArrayList<Usuario>) ois.readObject();
			usuarios = readObject;
			ois.close();
		} catch (EOFException e) {
			return usuarios;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public void excluir(Usuario usuario) throws ExclusaoFalhouException, BuscaFalhouException {
		List<Usuario> usuarios = buscarTodos();

		for (Usuario u : usuarios) {
			if (u.getId() == usuario.getId()) {
				usuarios.remove(u);
			}
		}

		try {
			salvar(usuarios);
		} catch (AdicaoFalhouException e) {
			e.printStackTrace();
		}

	}

}
