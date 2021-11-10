package application.interfaces;

import java.util.List;
import application.exceptions.AdicaoFalhouException;
import application.exceptions.BuscaFalhouException;
import application.exceptions.ExclusaoFalhouException;
import application.model.Usuario;

public interface RepositoryInterface {

	public void adiciona(Usuario usuario) throws AdicaoFalhouException;

	public Usuario buscarPorId(long id) throws BuscaFalhouException;

	public List<Usuario> buscarTodos() throws BuscaFalhouException;

	public void excluir(Usuario usuario) throws ExclusaoFalhouException;

}
