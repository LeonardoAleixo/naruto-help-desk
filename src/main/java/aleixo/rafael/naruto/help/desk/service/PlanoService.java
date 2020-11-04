package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.Plano;
import aleixo.rafael.naruto.help.desk.object.PlanoObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;

public interface PlanoService {
	public PlanoObject encontrarPorID(Integer idPlano);

	public List<PlanoObject> encontrarTodos();

	public GenericoObject salvar(PlanoObject Plano);
	
	public GenericoObject editar(PlanoObject Plano);

	public GenericoObject deletarPorID(Integer idPlano);

	public Plano preencherPlano(PlanoObject planoObjectResponse);

	public PlanoObject preencherPlanoObjectResponse(Plano plano);
}
