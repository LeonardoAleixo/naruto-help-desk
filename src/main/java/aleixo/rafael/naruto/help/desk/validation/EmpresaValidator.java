package aleixo.rafael.naruto.help.desk.validation;

import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.object.EmpresaObject;
import aleixo.rafael.naruto.help.desk.util.ValidateMessages;

@Service
public class EmpresaValidator {
	
	
	static final String CPO_NOME = "Nome";
	static final String CPO_PLANO = "Plano";
	static final String CPO_CNPJ = "CNPJ";
	
	public boolean validateEmpresa(EmpresaObject empresaObject) {
		if (empresaObject.getNome() == null || empresaObject.getNome().length() ==  ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_NOME));
		}
		if (empresaObject.getNome().length() > 100) {
			throw new ValidateException(ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_NOME).replace("(tam)", "100"));
		}
		if (empresaObject.getPlano() == null) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_PLANO));
		}
		if (empresaObject.getCnpj() == null || empresaObject.getCnpj().length() ==  ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_CNPJ));
		}
		if (empresaObject.getCnpj().length() > 30) {
			throw new ValidateException(ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_CNPJ).replace("(tam)",  "30"));
		}
		return true;
	}
}
