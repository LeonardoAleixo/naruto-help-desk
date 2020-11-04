package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.model.HistoricoChamado;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.HistoricoChamadoObject;
import aleixo.rafael.naruto.help.desk.repository.HistoricoChamadoRepository;
import aleixo.rafael.naruto.help.desk.service.HistoricoChamadoService;

@Service
public class HistoricoChamadoServiceImpl implements HistoricoChamadoService {

	@Autowired
	private HistoricoChamadoRepository historicoChamadoRepository;

	@Override
	public HistoricoChamadoObject encontrarPorID(Long idHistoricoChamado) {
		Optional<HistoricoChamado> historicoChamado = historicoChamadoRepository.findById(idHistoricoChamado);
		if (historicoChamado.isPresent()) {
			return preencherHistoricoChamadoObjectResponse(historicoChamado.get());
		} else {
			throw new NaoEncontradoException("Usuário não encontrado");
		}
	}

	@Override
	public List<HistoricoChamadoObject> encontrarTodos() {
		List<HistoricoChamado> listaHistoricoChamado = historicoChamadoRepository.encontrarTodos();
		List<HistoricoChamadoObject> listaRetorno = new ArrayList<>();
		for (HistoricoChamado historicoChamado : listaHistoricoChamado) {
			listaRetorno.add(preencherHistoricoChamadoObjectResponse(historicoChamado));
		}
		return listaRetorno;
	}

	@Override
	public GenericoObject salvar(HistoricoChamadoObject historicoChamadoObject) {
		HistoricoChamado historicoChamado = preencherHistoricoChamado(historicoChamadoObject);
		historicoChamadoRepository.save(historicoChamado);
		return new GenericoObject(200);
	}

	@Override
	public HistoricoChamado preencherHistoricoChamado(HistoricoChamadoObject historicoChamadoObjectResponse) {
		HistoricoChamado historicoChamado = new HistoricoChamado();
		historicoChamado.setChamado(historicoChamadoObjectResponse.getChamado());
		historicoChamado.setData(new Date(historicoChamadoObjectResponse.getData()));
		historicoChamado.setDescricao(historicoChamadoObjectResponse.getDescricao());
		historicoChamado.setIdHistoricoChamado(historicoChamadoObjectResponse.getIdHistoricoChamado());
		historicoChamado.setUsuario(historicoChamadoObjectResponse.getUsuario());
		return historicoChamado;
	}

	@Override
	public HistoricoChamadoObject preencherHistoricoChamadoObjectResponse(HistoricoChamado historicoChamado) {
		HistoricoChamadoObject historicoChamadoObject = new HistoricoChamadoObject();
		historicoChamadoObject.setChamado(historicoChamado.getChamado());
		historicoChamadoObject.setData(historicoChamado.getData().getTime());
		historicoChamadoObject.setDescricao(historicoChamado.getDescricao());
		historicoChamadoObject.setIdHistoricoChamado(historicoChamado.getIdHistoricoChamado());
		historicoChamadoObject.setUsuario(historicoChamado.getUsuario());
		return historicoChamadoObject;
	}

}
