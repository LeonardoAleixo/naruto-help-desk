package aleixo.rafael.naruto.help.desk.object;

public class PlanoObject {

	private Integer idPlano;
	private String nome;
	private Integer quantidadeChamadoMes;
	private Double valor;
	private Boolean status;
	private String icone;

	public Integer getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeChamadoMes() {
		return quantidadeChamadoMes;
	}

	public void setQuantidadeChamadoMes(Integer quantidadeChamadoMes) {
		this.quantidadeChamadoMes = quantidadeChamadoMes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

}