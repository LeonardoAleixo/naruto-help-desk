package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.TipoUsuario;
import aleixo.rafael.naruto.help.desk.object.TipoUsuarioObject;

public interface TipoUsuarioService {
	public List<TipoUsuarioObject> encontrarTodos();

	public TipoUsuarioObject encontrarPorID(Integer idTipoUsuario);

	public TipoUsuario preencherTipoUsuario(TipoUsuarioObject tipoUsuarioObjectResponse);

	public TipoUsuarioObject preencherTipoUsuarioObjectResponse(TipoUsuario tipoUsuario);

}
