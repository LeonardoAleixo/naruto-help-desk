package aleixo.rafael.naruto.help.desk.object;

import com.google.gson.Gson;

public class EmpresaObject {

	private Long idEmpresa;
	private String nome;
	private Integer plano;
	private Boolean status;
	private String cnpj;

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPlano() {
		return this.plano;
	}

	public void setPlano(Integer plano) {
		this.plano = plano;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}