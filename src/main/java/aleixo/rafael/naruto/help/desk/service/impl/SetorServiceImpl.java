package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.model.Setor;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.SetorObject;
import aleixo.rafael.naruto.help.desk.repository.SetorRepository;
import aleixo.rafael.naruto.help.desk.service.SetorService;

@Service
public class SetorServiceImpl implements SetorService {

	@Autowired
	private SetorRepository setorRepository;

	@Override
	public SetorObject encontrarPorID(Integer idSetor) {
		Optional<Setor> setor = setorRepository.findById(idSetor);
		if (setor.isPresent()) {
			return preencherSetorObjectResponse(setor.get());
		} else {
			throw new NaoEncontradoException("Setor não encontrado");
		}
	}

	@Override
	public List<SetorObject> encontrarTodos() {
		List<Setor> listaSetor = setorRepository.encontrarTodos();
		List<SetorObject> listaRetorno = new ArrayList<>();
		for (Setor setor : listaSetor) {
			listaRetorno.add(preencherSetorObjectResponse(setor));
		}
		return listaRetorno;
	}

	@Override
	public GenericoObject salvar(SetorObject setorObject) {
		Setor setor = preencherSetor(setorObject);
		setorRepository.save(setor);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject editar(SetorObject setorObject) {
		Setor setor = preencherSetor(setorObject);
		if (setor.getIdSetor() == null) {
			throw new NaoEncontradoException("Id não encontrado");
		}
		setorRepository.save(setor);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject deletarPorID(Integer idSetor) {
		try {
			Optional<Setor> setor = setorRepository.findById(idSetor);
			if (setor.isPresent()) {
				setor.get().setStatus(false);
				setorRepository.save(setor.get());
				return new GenericoObject(200);
			} else {
				return new GenericoObject(403);
			}
		} catch (Exception e) {
			return new GenericoObject(500);
		}
	}

	@Override
	public Setor preencherSetor(SetorObject setorObjectResponse) {
		Setor setor = new Setor();
		setor.setIdSetor(setorObjectResponse.getIdSetor());
		setor.setNome(setorObjectResponse.getNome());
		setor.setStatus(setorObjectResponse.getStatus());
		return setor;

	}

	@Override
	public SetorObject preencherSetorObjectResponse(Setor setor) {
		SetorObject setorObject = new SetorObject();
		setorObject.setIdSetor(setor.getIdSetor());
		setorObject.setNome(setor.getNome());
		setorObject.setStatus(setor.getStatus());
		return setorObject;
	}

}
