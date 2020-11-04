package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.HistoricoChamado;
import aleixo.rafael.naruto.help.desk.object.HistoricoChamadoObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;

public interface HistoricoChamadoService {
	public HistoricoChamadoObject encontrarPorID(Long idHistoricoChamado);

	public List<HistoricoChamadoObject> encontrarTodos();

	public GenericoObject salvar(HistoricoChamadoObject HistoricoChamado);

	public HistoricoChamado preencherHistoricoChamado(HistoricoChamadoObject historicoChamadoObjectResponse);

	public HistoricoChamadoObject preencherHistoricoChamadoObjectResponse(HistoricoChamado historicoChamado);
}
