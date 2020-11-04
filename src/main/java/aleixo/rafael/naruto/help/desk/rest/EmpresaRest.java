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
import aleixo.rafael.naruto.help.desk.object.EmpresaObject;
import aleixo.rafael.naruto.help.desk.object.GenericoObject;
import aleixo.rafael.naruto.help.desk.service.EmpresaService;

@RestController
@Validated
@RequestMapping("/empresa")
public class EmpresaRest {
	
	@Autowired
	EmpresaService empresaService;

	@PostMapping("")
	GenericoObject salvar(@RequestBody EmpresaObject empresaObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return empresaService.salvar(empresaObjectResponse);
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}

	@PutMapping("")
	GenericoObject atualizar(@RequestBody EmpresaObject empresaObjectResponse, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return empresaService.editar(empresaObjectResponse);
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

	@DeleteMapping("/{idEmpresa}")
	void deletar(@PathVariable Long idEmpresa, HttpServletResponse response) {
		response.setStatus(empresaService.deletarPorID(idEmpresa).getId());
	}

	@GetMapping("/listar/")
	List<EmpresaObject> listar(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return empresaService.encontrarTodos();
	}

	@GetMapping("/id/{idEmpresa}")
	EmpresaObject get(@PathVariable Long idEmpresa, HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			return empresaService.encontrarPorID(idEmpresa);
		} catch (NaoEncontradoException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
