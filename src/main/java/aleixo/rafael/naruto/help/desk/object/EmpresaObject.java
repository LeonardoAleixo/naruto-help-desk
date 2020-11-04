package aleixo.rafael.naruto.help.desk.object;

public class EmpresaObject {

	private Long idEmpresa;
	private String nome;
	private Integer plano;
	private Boolean status;

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

}