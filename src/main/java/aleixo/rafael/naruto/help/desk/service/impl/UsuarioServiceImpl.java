package aleixo.rafael.naruto.help.desk.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.model.Usuario;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;
import aleixo.rafael.naruto.help.desk.repository.UsuarioRepository;
import aleixo.rafael.naruto.help.desk.service.UsuarioService;
import aleixo.rafael.naruto.help.desk.util.MD5;
import aleixo.rafael.naruto.help.desk.validation.UsuarioValidator;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private MD5 md5;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioValidator usuarioValidator;

	@Override
	public UsuarioObject encontrarPorID(Long idUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		if (usuario.isPresent()) {
			return preencherUsuarioObjectResponse(usuario.get());
		} else {
			throw new NaoEncontradoException("Usuário não encontrado");
		}
	}

	@Override
	public List<UsuarioObject> encontrarTodos(Long idEmpresa) {
		List<Usuario> listaUsuario = usuarioRepository.encontrarPorEmpresaEqual(idEmpresa);
		List<UsuarioObject> listaRetorno = new ArrayList<>();
		for (Usuario usuario : listaUsuario) {
			listaRetorno.add(preencherUsuarioObjectResponse(usuario));
		}
		return listaRetorno;
	}
	
	@Override
	public List<UsuarioObject> encontrarTodos() {
		List<Usuario> listaUsuario = usuarioRepository.encontrarTodos();
		List<UsuarioObject> listaRetorno = new ArrayList<>();
		for (Usuario usuario : listaUsuario) {
			listaRetorno.add(preencherUsuarioObjectResponse(usuario));
		}
		return listaRetorno;
	}

	@Override
	public String salvar(UsuarioObject usuarioObjectResponse) {
		try {
			Optional<Usuario> temp = usuarioRepository.encontrarPorEmailEqual(usuarioObjectResponse.getEmail());
			if (temp.isPresent()) {
				throw new ValidateException("Email já está sendo utilizado");
			}
			
			Usuario usuario = preencherUsuario(usuarioObjectResponse, true);
			usuarioRepository.save(usuario);
			return preencherUsuarioObjectResponse(usuario).toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String editar(UsuarioObject usuarioObjectResponse) {
		try {
			Optional<Usuario> temp = usuarioRepository.encontrarPorEmailEqual(usuarioObjectResponse.getEmail());
			if (temp.isPresent() && temp.get().getIdUsuario() != usuarioObjectResponse.getIdUsuario()) {
				throw new ValidateException("Email já está sendo utilizado");
			}
			Usuario usuario = preencherUsuario(usuarioObjectResponse, false);
			if (usuario.getIdUsuario() == null) {
				throw new NaoEncontradoException("Id não encontrado");
			}
			usuarioRepository.save(usuario);
			return preencherUsuarioObjectResponse(usuario).toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public GenericoObject deletarPorID(Long idUsuario) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
			if (usuario.isPresent()) {
				usuario.get().setStatus(false);
				usuarioRepository.save(usuario.get());
				return new GenericoObject(200);
			} else {
				return new GenericoObject(403);
			}
		} catch (Exception e) {
			return new GenericoObject(500);
		}
	}

	@Override
	public Usuario preencherUsuario(UsuarioObject usuarioObjectResponse, boolean validarSenha) {
		if (usuarioValidator.validateUser(usuarioObjectResponse, validarSenha)) {
			Usuario usuario = new Usuario();
			usuario.setEmail(usuarioObjectResponse.getEmail());
			usuario.setEmpresa(usuarioObjectResponse.getEmpresa());
			usuario.setIdUsuario(usuarioObjectResponse.getIdUsuario());
			usuario.setNome(usuarioObjectResponse.getNome());
			try {
				usuario.setSenha(md5.encriptar(usuarioObjectResponse.getSenha()));
			} catch (NoSuchAlgorithmException e) {
			}
			usuario.setSetor(usuarioObjectResponse.getSetor());
			usuario.setSobrenome(usuarioObjectResponse.getSobrenome());
			usuario.setTipoUsuario(usuarioObjectResponse.getTipoUsuario());
			usuario.setStatus(usuarioObjectResponse.getStatus() == null ? true : usuarioObjectResponse.getStatus());
			return usuario;
		}
		return null;
	}

	@Override
	public UsuarioObject preencherUsuarioObjectResponse(Usuario usuario) {
		UsuarioObject usuarioObjectResponse = new UsuarioObject();
		usuarioObjectResponse.setEmail(usuario.getEmail());
		usuarioObjectResponse.setEmpresa(usuario.getEmpresa());
		usuarioObjectResponse.setIdUsuario(usuario.getIdUsuario());
		usuarioObjectResponse.setNome(usuario.getNome());
		usuarioObjectResponse.setSenha(null);
		usuarioObjectResponse.setSetor(usuario.getSetor());
		usuarioObjectResponse.setSobrenome(usuario.getSobrenome());
		usuarioObjectResponse.setTipoUsuario(usuario.getTipoUsuario());
		usuarioObjectResponse.setStatus(usuario.getStatus());
		return usuarioObjectResponse;

	}

}
