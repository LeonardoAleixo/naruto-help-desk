package aleixo.rafael.naruto.help.desk.rest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.object.ObjectLogin;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;
import aleixo.rafael.naruto.help.desk.service.LoginService;

@RestController
@Validated
@RequestMapping("/login")
public class LoginRest {
	@Autowired
	private LoginService loginService;

	@PostMapping("")
	UsuarioObject logar(@RequestBody ObjectLogin loginObject, HttpServletResponse response, ServletRequest request) {
		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return loginService.logar(loginObject);
		} catch (ValidateException e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		} catch (Exception e) {
			response.setStatus(Integer.parseInt(e.getMessage()));
			return null;
		}
	}
}
