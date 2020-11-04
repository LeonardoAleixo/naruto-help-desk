package aleixo.rafael.naruto.help.desk.service;

import aleixo.rafael.naruto.help.desk.object.ObjectLogin;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;

public interface LoginService {
	
	public UsuarioObject logar(ObjectLogin objectLogin) throws Exception;
}
