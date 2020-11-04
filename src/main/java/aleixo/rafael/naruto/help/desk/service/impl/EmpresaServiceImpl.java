package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.model.Empresa;
import aleixo.rafael.naruto.help.desk.object.EmpresaObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.repository.EmpresaRepository;
import aleixo.rafael.naruto.help.desk.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public EmpresaObject encontrarPorID(Long idEmpresa) {
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		if (empresa.isPresent()) {
			return preencherEmpresaObjectResponse(empresa.get());
		} else {
			throw new NaoEncontradoException("Usuário não encontrado");
		}
	}

	@Override
	public List<EmpresaObject> encontrarTodos() {
		List<Empresa> listaEmpresa = empresaRepository.encontrarTodos();
		List<EmpresaObject> listaRetorno = new ArrayList<>();
		for (Empresa empresa : listaEmpresa) {
			listaRetorno.add(preencherEmpresaObjectResponse(empresa));
		}
		return listaRetorno;
	}

	@Override
	public GenericoObject salvar(EmpresaObject empresaObject) {
		Empresa empresa = preencherEmpresa(empresaObject);
		empresaRepository.save(empresa);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject editar(EmpresaObject empresaObject) {
		Empresa empresa = preencherEmpresa(empresaObject);
		if (empresa.getIdEmpresa() == null) {
			throw new NaoEncontradoException("Id não encontrado");
		}
		empresaRepository.save(empresa);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject deletarPorID(Long idEmpresa) {
		try {
			Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
			if (empresa.isPresent()) {
				empresa.get().setStatus(false);
				empresaRepository.save(empresa.get());
				return new GenericoObject(200);
			} else {
				return new GenericoObject(403);
			}
		} catch (Exception e) {
			return new GenericoObject(500);
		}
	}

	@Override
	public Empresa preencherEmpresa(EmpresaObject empresaObjectResponse) {
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(empresaObjectResponse.getIdEmpresa());
		empresa.setNome(empresaObjectResponse.getNome());
		empresa.setPlano(empresaObjectResponse.getPlano());
		empresa.setStatus(empresaObjectResponse.getStatus());
		return empresa;
	}

	@Override
	public EmpresaObject preencherEmpresaObjectResponse(Empresa empresa) {
		EmpresaObject empresaObject = new EmpresaObject();
		empresaObject.setIdEmpresa(empresa.getIdEmpresa());
		empresaObject.setNome(empresa.getNome());
		empresaObject.setPlano(empresa.getPlano());
		empresaObject.setStatus(empresa.getStatus());
		return empresaObject;
	}

}
