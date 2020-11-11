package aleixo.rafael.naruto.help.desk.object;

import com.google.gson.Gson;

public class ChamadoObject {

	private Long idChamado;
	private Long cliente;
	private Long atendente;
	private Long dataInicio;
	private Long dataTermino;
	private Integer status;
	private Integer setor;
	private String titulo;
	private String descricao;
	private EmpresaObject empresa;

	public Long getIdChamado() {
		return this.idChamado;
	}

	public void setIdChamado(Long idChamado) {
		this.idChamado = idChamado;
	}

	public Long getCliente() {
		return this.cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getAtendente() {
		return this.atendente;
	}

	public void setAtendente(Long atendente) {
		this.atendente = atendente;
	}

	public Long getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Long dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Long getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(Long dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSetor() {
		return this.setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EmpresaObject getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaObject empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}