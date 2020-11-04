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
import aleixo.rafael.naruto.help.desk.object.SetorObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.service.SetorService;

@RestController
@Validated
@RequestMapping("/setor")
public class SetorRest {
	
	@Autowired
	SetorService setorService;

	@PostMapping("")
	GenericoObject salvar(@RequestBody SetorObject setorObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return setorService.salvar(setorObjectResponse);
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@PutMapping("")
	GenericoObject atualizar(@RequestBody SetorObject setorObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return setorService.editar(setorObjectResponse);
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

	@DeleteMapping("/{idSetor}")
	void deletar(@PathVariable Integer idSetor, HttpServletResponse response) {
		response.setStatus(setorService.deletarPorID(idSetor).getId());
	}

	@GetMapping("/listar/")
	List<SetorObject> listar(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return setorService.encontrarTodos();
	}

	@GetMapping("/id/{idSetor}")
	SetorObject get(@PathVariable Integer idSetor, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			return setorService.encontrarPorID(idSetor);
		} catch (NaoEncontradoException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
