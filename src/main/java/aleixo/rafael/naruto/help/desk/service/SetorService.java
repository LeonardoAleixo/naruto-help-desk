package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.Setor;
import aleixo.rafael.naruto.help.desk.object.SetorObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;

public interface SetorService {
	public SetorObject encontrarPorID(Integer idSetor);

	public List<SetorObject> encontrarTodos();

	public GenericoObject salvar(SetorObject Setor);

	public GenericoObject editar(SetorObject Setor);

	public GenericoObject deletarPorID(Integer idSetor);

	public Setor preencherSetor(SetorObject setorObjectResponse);

	public SetorObject preencherSetorObjectResponse(Setor setor);
}
