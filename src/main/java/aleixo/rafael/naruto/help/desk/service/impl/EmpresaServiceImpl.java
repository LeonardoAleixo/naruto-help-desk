package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.model.Empresa;
import aleixo.rafael.naruto.help.desk.object.EmpresaObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.repository.EmpresaRepository;
import aleixo.rafael.naruto.help.desk.service.EmpresaService;
import aleixo.rafael.naruto.help.desk.validation.EmpresaValidator;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaValidator empresaValidator;

	@Override
	public EmpresaObject encontrarPorID(Long idEmpresa) {
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		if (empresa.isPresent()) {
			return preencherEmpresaObjectResponse(empresa.get());
		} else {
			throw new NaoEncontradoException("Empresa não encontrado");
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
	public String salvar(EmpresaObject empresaObject) {
		try {
			Optional<Empresa> temp = empresaRepository.encontrarPorCnpjEqual(empresaObject.getCnpj());
			if (temp.isPresent()) {
				throw new ValidateException("Cnpj já está sendo utilizado");
			}
			Empresa empresa = preencherEmpresa(empresaObject);
			empresaRepository.save(empresa);
			return preencherEmpresaObjectResponse(empresa).toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String editar(EmpresaObject empresaObject) {
		try {
			Optional<Empresa> temp = empresaRepository.encontrarPorCnpjEqual(empresaObject.getCnpj());
			if (temp.isPresent() && temp.get().getIdEmpresa() != empresaObject.getIdEmpresa()) {
				throw new ValidateException("Cnpj já está sendo utilizado");
			}
			Empresa empresa = preencherEmpresa(empresaObject);
			if (empresa.getIdEmpresa() == null) {
				throw new NaoEncontradoException("Id não encontrado");
			}
			empresaRepository.save(empresa);
			return preencherEmpresaObjectResponse(empresa).toString();
		} catch (Exception e) {
			return e.getMessage();
		}
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
		if (empresaValidator.validateEmpresa(empresaObjectResponse)) {
			Empresa empresa = new Empresa();
			empresa.setIdEmpresa(empresaObjectResponse.getIdEmpresa());
			empresa.setNome(empresaObjectResponse.getNome());
			empresa.setPlano(empresaObjectResponse.getPlano());
			empresa.setStatus(empresaObjectResponse.getStatus() == null ? true : empresaObjectResponse.getStatus());
			empresa.setCnpj(empresaObjectResponse.getCnpj());
			return empresa;
		}
		return null;
	}

	@Override
	public EmpresaObject preencherEmpresaObjectResponse(Empresa empresa) {
		EmpresaObject empresaObject = new EmpresaObject();
		empresaObject.setIdEmpresa(empresa.getIdEmpresa());
		empresaObject.setNome(empresa.getNome());
		empresaObject.setPlano(empresa.getPlano());
		empresaObject.setStatus(empresa.getStatus());
		empresaObject.setCnpj(empresa.getCnpj());
		return empresaObject;
	}

}
