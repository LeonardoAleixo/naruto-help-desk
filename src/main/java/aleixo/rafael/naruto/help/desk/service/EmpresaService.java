package aleixo.rafael.naruto.help.desk.service;

import java.util.List;

import aleixo.rafael.naruto.help.desk.model.Empresa;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.EmpresaObject;

public interface EmpresaService {
	public EmpresaObject encontrarPorID(Long idEmpresa);

	public List<EmpresaObject> encontrarTodos();

	public String salvar(EmpresaObject Empresa);
	
	public String editar(EmpresaObject Empresa);

	public GenericoObject deletarPorID(Long idEmpresa);

	public Empresa preencherEmpresa(EmpresaObject empresaObjectResponse);

	public EmpresaObject preencherEmpresaObjectResponse(Empresa empresa);

}
