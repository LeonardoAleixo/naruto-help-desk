package aleixo.rafael.naruto.help.desk.validation;

import org.springframework.stereotype.Service;

import aleixo.rafael.naruto.help.desk.exception.ValidateException;
import aleixo.rafael.naruto.help.desk.object.ChamadoObject;
import aleixo.rafael.naruto.help.desk.util.ValidateMessages;

@Service
public class ChamadoValidator {

	static final String CPO_CLIENTE = "Cliente";
	static final String CPO_ATENDENTE = "Atendente";
	static final String CPO_DATA_INICIO = "Data de início";
	static final String CPO_TITULO = "Título";
	static final String CPO_DESCRICAO = "Descrição";

	public boolean validateChamado(ChamadoObject chamadoObject) {
		if (chamadoObject.getCliente() == null) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_CLIENTE));
		}
	
		if (chamadoObject.getDataInicio() == null) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_DATA_INICIO));
		}
		if (chamadoObject.getTitulo() == null || chamadoObject.getTitulo().length() == ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_TITULO));
		}
		if (chamadoObject.getTitulo().length() > 50) {
			throw new ValidateException(
					ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_TITULO).replace("(tam)", "50"));
		}
		
		if (chamadoObject.getDescricao() == null || chamadoObject.getDescricao().length() == ValidateMessages.ZERO) {
			throw new ValidateException(ValidateMessages.MSG_NAO_INFORMADO.replace("(cpo)", CPO_DESCRICAO));
		}
		if (chamadoObject.getDescricao().length() > 1000) {
			throw new ValidateException(
					ValidateMessages.MSG_TAMANHO_MAX.replace("(cpo)", CPO_DESCRICAO).replace("(tam)", "1000"));
		}
		return true;
	}
}
