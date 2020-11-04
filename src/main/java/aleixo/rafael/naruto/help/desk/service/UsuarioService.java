package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.Usuario;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;

public interface UsuarioService {

	public UsuarioObject encontrarPorID(Long idUsuario );

	public List<UsuarioObject> encontrarTodos(Long idEmpresa);

	public GenericoObject salvar(UsuarioObject Usuario);
	
	public GenericoObject editar(UsuarioObject Usuario);

	public GenericoObject deletarPorID(Long idUsuario);

	public Usuario preencherUsuario(UsuarioObject usuarioObjectResponse);

	public UsuarioObject preencherUsuarioObjectResponse(Usuario usuario);



}