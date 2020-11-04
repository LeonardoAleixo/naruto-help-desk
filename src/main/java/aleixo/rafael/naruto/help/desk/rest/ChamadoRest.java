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
import aleixo.rafael.naruto.help.desk.object.ChamadoObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.service.ChamadoService;

@RestController
@Validated
@RequestMapping("/chamado")
public class ChamadoRest {

	@Autowired
	ChamadoService chamadoService;

	@PostMapping("")
	GenericoObject salvar(@RequestBody ChamadoObject chamadoObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return chamadoService.salvar(chamadoObjectResponse);
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@PutMapping("")
	GenericoObject atualizar(@RequestBody ChamadoObject chamadoObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return chamadoService.editar(chamadoObjectResponse);
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

	@DeleteMapping("/{idChamado}")
	void deletar(@PathVariable Long idChamado, HttpServletResponse response) {
		response.setStatus(chamadoService.deletarPorID(idChamado).getId());
	}

	@GetMapping("/listar/")
	List<ChamadoObject> listar(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return chamadoService.encontrarTodos();
	}

	@GetMapping("/id/{idChamado}")
	ChamadoObject get(@PathVariable Long idChamado, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			return chamadoService.encontrarPorID(idChamado);
		} catch (NaoEncontradoException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
