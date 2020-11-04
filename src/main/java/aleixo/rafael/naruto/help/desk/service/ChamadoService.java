package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.Chamado;
import aleixo.rafael.naruto.help.desk.object.ChamadoObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;

public interface ChamadoService {
	public ChamadoObject encontrarPorID(Long idChamado);

	public List<ChamadoObject> encontrarTodos();

	public GenericoObject salvar(ChamadoObject Chamado);
	
	public GenericoObject editar(ChamadoObject Chamado);

	public GenericoObject deletarPorID(Long idChamado);

	public Chamado preencherChamado(ChamadoObject chamadoObjectResponse);

	public ChamadoObject preencherChamadoObjectResponse(Chamado chamado);
}
