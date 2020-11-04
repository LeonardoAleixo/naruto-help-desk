package aleixo.rafael.naruto.help.desk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.model.TipoUsuario;
import aleixo.rafael.naruto.help.desk.object.TipoUsuarioObject;
import aleixo.rafael.naruto.help.desk.repository.TipoUsuarioRepository;
import aleixo.rafael.naruto.help.desk.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public List<TipoUsuarioObject> encontrarTodos() {
		List<TipoUsuario> listaTipoUsuario = tipoUsuarioRepository.encontrarTodos();
		List<TipoUsuarioObject> listaRetorno = new ArrayList<>();
		for (TipoUsuario tipoUsuario : listaTipoUsuario) {
			listaRetorno.add(preencherTipoUsuarioObjectResponse(tipoUsuario));
		}
		return listaRetorno;
	}

	@Override
	public TipoUsuarioObject encontrarPorID(Integer idTipoUsuario) {
		Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario);
		if (tipoUsuario.isPresent()) {
			return preencherTipoUsuarioObjectResponse(tipoUsuario.get());
		} else {
			throw new NaoEncontradoException("Tipo de Usuário não encontrado");
		}
	}

	@Override
	public TipoUsuario preencherTipoUsuario(TipoUsuarioObject tipoUsuarioObjectResponse) {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(tipoUsuarioObjectResponse.getIdTipoUsuario());
		tipoUsuario.setNome(tipoUsuarioObjectResponse.getNome());
		return tipoUsuario;
	}

	@Override
	public TipoUsuarioObject preencherTipoUsuarioObjectResponse(TipoUsuario tipoUsuario) {
		TipoUsuarioObject tipoUsuarioObject = new TipoUsuarioObject();
		tipoUsuarioObject.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
		tipoUsuarioObject.setNome(tipoUsuario.getNome());
		return tipoUsuarioObject;
	}

}
