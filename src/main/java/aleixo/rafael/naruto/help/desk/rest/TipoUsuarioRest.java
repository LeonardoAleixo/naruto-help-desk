package aleixo.rafael.naruto.help.desk.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aleixo.rafael.naruto.help.desk.exception.NaoEncontradoException;
import aleixo.rafael.naruto.help.desk.object.TipoUsuarioObject;
import aleixo.rafael.naruto.help.desk.service.TipoUsuarioService;

@RestController
@Validated
@RequestMapping("/tipo_usuario")
public class TipoUsuarioRest {

	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	@GetMapping("/listar/")
	List<TipoUsuarioObject> listar(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return tipoUsuarioService.encontrarTodos();
	}

	@GetMapping("/id/{idTipoUsuario}")
	TipoUsuarioObject get(@PathVariable Integer idTipoUsuario, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			return tipoUsuarioService.encontrarPorID(idTipoUsuario);
		} catch (NaoEncontradoException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
