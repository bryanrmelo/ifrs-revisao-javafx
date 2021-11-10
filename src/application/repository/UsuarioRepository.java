package application.repository;

import java.util.List;
import application.exceptions.AdicaoFalhouException;
import application.exceptions.BuscaFalhouException;
import application.exceptions.ExclusaoFalhouException;
import application.interfaces.RepositoryInterface;
import application.model.Usuario;

public class UsuarioRepository implements RepositoryInterface {

	@Override
	public void adiciona(Usuario usuario) throws AdicaoFalhouException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscarPorId(long id) throws BuscaFalhouException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() throws BuscaFalhouException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Usuario usuario) throws ExclusaoFalhouException {
		// TODO Auto-generated method stub

	}

}
