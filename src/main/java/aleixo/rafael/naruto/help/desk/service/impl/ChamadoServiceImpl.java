package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.model.Chamado;
import aleixo.rafael.naruto.help.desk.object.ChamadoObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.repository.ChamadoRepository;
import aleixo.rafael.naruto.help.desk.service.ChamadoService;

@Service
public class ChamadoServiceImpl implements ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Override
	public ChamadoObject encontrarPorID(Long idChamado) {
		Optional<Chamado> chamado = chamadoRepository.findById(idChamado);
		if (chamado.isPresent()) {
			return preencherChamadoObjectResponse(chamado.get());
		} else {
			throw new NaoEncontradoException("Usuário não encontrado");
		}
	}

	@Override
	public List<ChamadoObject> encontrarTodos() {
		List<Chamado> listaChamado = chamadoRepository.encontrarTodos();
		List<ChamadoObject> listaRetorno = new ArrayList<>();
		for (Chamado chamado : listaChamado) {
			listaRetorno.add(preencherChamadoObjectResponse(chamado));
		}
		return listaRetorno;
	}

	@Override
	public GenericoObject salvar(ChamadoObject chamadoObject) {
		Chamado chamado = preencherChamado(chamadoObject);
		chamadoRepository.save(chamado);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject editar(ChamadoObject chamadoObject) {
		Chamado chamado = preencherChamado(chamadoObject);
		if (chamado.getIdChamado() == null) {
			throw new NaoEncontradoException("Id não encontrado");
		}
		chamadoRepository.save(chamado);
		return new GenericoObject(200);
	}

	@Override
	public GenericoObject deletarPorID(Long idChamado) {
		try {
			Optional<Chamado> chamado = chamadoRepository.findById(idChamado);
			if (chamado.isPresent()) {
				chamado.get().setStatus(0);
				chamadoRepository.save(chamado.get());
				return new GenericoObject(200);
			} else {
				return new GenericoObject(403);
			}
		} catch (Exception e) {
			return new GenericoObject(500);
		}
	}

	@Override
	public Chamado preencherChamado(ChamadoObject chamadoObjectResponse) {
		Chamado chamado = new Chamado();
		chamado.setAtendente(chamadoObjectResponse.getAtendente());
		chamado.setCliente(chamadoObjectResponse.getCliente());
		chamado.setDataInicio(
				chamadoObjectResponse.getDataInicio() != null ? new Date(chamadoObjectResponse.getDataInicio()) : null);
		chamado.setDataTermino(
				chamadoObjectResponse.getDataTermino() != null ? new Date(chamadoObjectResponse.getDataTermino())
						: null);
		chamado.setIdChamado(chamadoObjectResponse.getIdChamado());
		chamado.setSetor(chamadoObjectResponse.getSetor());
		chamado.setStatus(chamadoObjectResponse.getStatus());
		chamado.setTitulo(chamadoObjectResponse.getTitulo());
		return chamado;
	}

	@Override
	public ChamadoObject preencherChamadoObjectResponse(Chamado chamado) {
		ChamadoObject chamadoObject = new ChamadoObject();
		chamadoObject.setAtendente(chamado.getAtendente());
		chamadoObject.setCliente(chamado.getCliente());
		chamadoObject.setDataInicio(chamado.getDataInicio() != null ? chamado.getDataInicio().getTime() : null);
		chamadoObject.setDataTermino(chamado.getDataTermino() != null ? chamado.getDataTermino().getTime() : null);
		chamadoObject.setIdChamado(chamado.getIdChamado());
		chamadoObject.setSetor(chamado.getSetor());
		chamadoObject.setStatus(chamado.getStatus());
		chamadoObject.setTitulo(chamado.getTitulo());
		return chamadoObject;
	}

}
