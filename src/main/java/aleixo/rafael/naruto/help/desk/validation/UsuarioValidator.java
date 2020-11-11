package aleixo.rafael.naruto.help.desk.validation;

import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.object.UsuarioObject;
import aleixo.rafael.naruto.help.desk.util.ValidateMessages;

@Service
public class UsuarioValidator {

	static final String CPO_NOME = "Nome";
	static final String CPO_SOBRENOME = "Sobrenome";
	static final String CPO_TIPO_USUARIO = "Tipo usuário";
	static final String CPO_EMPRESA = "Empresa";
	static final String CPO_EMAIL = "Email";
	static final String CPO_SENHA = "Senha";
	
	
	public boolean validateUser(UsuarioObject usuarioObject, boolean validarSenha) {
		if (usuarioObject.getNome() == null || usuarioObject.getNome().length() ==  ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_NOME));
		}
		if (usuarioObject.getNome().length() > 20) {
			throw new ValidateException(ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_NOME).replace("(tam)", "20"));
		}
		if (usuarioObject.getSobrenome() == null || usuarioObject.getSobrenome().length() ==  ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_SOBRENOME));
		}
		if (usuarioObject.getSobrenome().length() > 20) {
			throw new ValidateException(ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_SOBRENOME).replace("(tam)", "20"));
		}
		if (usuarioObject.getTipoUsuario() == null) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_TIPO_USUARIO));
		}
		if (usuarioObject.getEmpresa() == null) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_EMPRESA));
		}
		if (usuarioObject.getEmail() == null || usuarioObject.getEmail().length() ==  ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_EMAIL));
		}
		if (usuarioObject.getEmail().length() > 100) {
			throw new ValidateException(ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_EMAIL).replace("(tam)", "100"));
		}
		if (validarSenha) {			
			if (usuarioObject.getSenha() == null || usuarioObject.getSenha().length() ==  ValidateMessages.ZERO) {
				throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_SENHA));
			}
		}
		return true;
	}
}
