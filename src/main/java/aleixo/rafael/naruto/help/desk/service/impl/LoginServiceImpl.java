package aleixo.rafael.naruto.help.desk.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.model.Usuario;
import aleixo.rafael.naruto.help.desk.object.ObjectLogin;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;
import aleixo.rafael.naruto.help.desk.repository.UsuarioRepository;
import aleixo.rafael.naruto.help.desk.service.LoginService;
import aleixo.rafael.naruto.help.desk.service.UsuarioService;
import aleixo.rafael.naruto.help.desk.util.MD5;

@Service
public class LoginServiceImpl implements LoginService{
	


	@Autowired
	private MD5 md5;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioObject logar(ObjectLogin objectLogin) throws Exception {
		Optional<Usuario> usuario = usuarioRepository.encontrarPorEmailEqual(objectLogin.getEmail());
		if (usuario.isPresent()) {
			try {
				if (usuario.get().getSenha().equals(md5.encriptar(objectLogin.getSenha()))) {
					return usuarioService.preencherUsuarioObjectResponse(usuario.get());
				}else {
					throw new ValidateException("402");
				}
			}catch(NoSuchAlgorithmException e) {
				throw new Exception("500");
			}
		}else{
			throw new ValidateException("402"); 
		}
	}

}
