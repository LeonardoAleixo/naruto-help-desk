package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.model.Plano;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.PlanoObject;
import aleixo.rafael.naruto.help.desk.repository.PlanoRepository;
import aleixo.rafael.naruto.help.desk.service.PlanoService;

@Service
public class PlanoServiceImpl implements PlanoService {

	@Autowired
	private PlanoRepository planoRepository;

	@Override
	public PlanoObject encontrarPorID(Integer idPlano) {
		Optional<Plano> plano = planoRepository.findById(idPlano);
		if (plano.isPresent()) {
			return preencherPlanoObjectResponse(plano.get());
		} else {
			throw new NaoEncontradoException("Plano não encontrado");
		}
	}

	@Override
	public List<PlanoObject> encontrarTodos() {
		List<Plano> listaPlano = planoRepository.encontrarTodos();
		List<PlanoObject> listaRetorno = new ArrayList<>();
		for (Plano plano : listaPlano) {
			listaRetorno.add(preencherPlanoObjectResponse(plano));
		}
		return listaRetorno;
	}

	@Override
	public GenericoObject salvar(PlanoObject planoObject) {
		Plano plano = preencherPlano(planoObject);
		planoRepository.save(plano);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject editar(PlanoObject planoObject) {
		Plano plano = preencherPlano(planoObject);
		if (plano.getIdPlano() == null) {
			throw new NaoEncontradoException("Id não encontrado");
		}
		planoRepository.save(plano);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject deletarPorID(Integer idPlano) {
		try {
			Optional<Plano> plano = planoRepository.findById(idPlano);
			if (plano.isPresent()) {
				plano.get().setStatus(false);
				planoRepository.save(plano.get());
				return new GenericoObject(200);
			} else {
				return new GenericoObject(403);
			}
		} catch (Exception e) {
			return new GenericoObject(500);
		}
	}

	@Override
	public Plano preencherPlano(PlanoObject planoObjectResponse) {
		Plano plano = new Plano();
		plano.setIdPlano(planoObjectResponse.getIdPlano());
		plano.setNome(planoObjectResponse.getNome());
		plano.setQuantidadeChamadoMes(planoObjectResponse.getQuantidadeChamadoMes());
		plano.setValor(planoObjectResponse.getValor());
		return plano;
	}

	@Override
	public PlanoObject preencherPlanoObjectResponse(Plano plano) {
		PlanoObject planoObject = new PlanoObject();
		planoObject.setIdPlano(plano.getIdPlano());
		planoObject.setNome(plano.getNome());
		planoObject.setQuantidadeChamadoMes(plano.getQuantidadeChamadoMes());
		planoObject.setStatus(plano.getStatus());
		planoObject.setValor(plano.getValor());
		return planoObject;
	}

}
