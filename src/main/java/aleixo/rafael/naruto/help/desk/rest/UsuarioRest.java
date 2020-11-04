package aleixo.rafael.naruto.help.desk.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;
import aleixo.rafael.naruto.help.desk.service.UsuarioService;

@RestController
@Validated
@RequestMapping("/usuario")
public class UsuarioRest {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("")
	GenericoObject salvar(@RequestBody UsuarioObject usuarioObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return usuarioService.salvar(usuarioObjectResponse);
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@PutMapping("")
	GenericoObject atualizar(@RequestBody UsuarioObject usuarioObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return usuarioService.editar(usuarioObjectResponse);
		} catch (NaoEncontradoException e) {
			response.setStatus(400);
			return  new GenericoObject(400, e.getMessage());
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@DeleteMapping("/{idUsuario}")
	void deletar(@PathVariable Long idUsuario, HttpServletResponse response) {
		response.setStatus(usuarioService.deletarPorID(idUsuario).getId());
	}

	@GetMapping("/listar/{idEmpresa}")
	List<UsuarioObject> listar(@PathVariable Long idEmpresa, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return usuarioService.encontrarTodos(idEmpresa);
	}

	@GetMapping("/id/{idUsuario}")
	UsuarioObject get(@PathVariable Long idUsuario, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			return usuarioService.encontrarPorID(idUsuario);
		} catch (NaoEncontradoException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return null;
	}

}
