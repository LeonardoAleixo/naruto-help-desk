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
import aleixo.rafael.naruto.help.desk.object.PlanoObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.service.PlanoService;

@RestController
@Validated
@RequestMapping("/plano")
public class PlanoRest {
	
	@Autowired
	private PlanoService planoService;
	
	
	
	@PostMapping("")
	GenericoObject salvar(@RequestBody PlanoObject planoObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return planoService.salvar(planoObjectResponse);
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@PutMapping("")
	GenericoObject atualizar(@RequestBody PlanoObject planoObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return planoService.editar(planoObjectResponse);
		} catch (NaoEncontradoException e) {
			response.setStatus(400);
			return new GenericoObject(400, e.getMessage());
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@DeleteMapping("/{idPlano}")
	void deletar(@PathVariable Integer idPlano, HttpServletResponse response) {
		response.setStatus(planoService.deletarPorID(idPlano).getId());
	}

	@GetMapping("/listar/")
	List<PlanoObject> listar(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return planoService.encontrarTodos();
	}

	@GetMapping("/id/{idPlano}")
	PlanoObject get(@PathVariable Integer idPlano, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			return planoService.encontrarPorID(idPlano);
		} catch (NaoEncontradoException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
