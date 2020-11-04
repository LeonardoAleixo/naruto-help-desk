package aleixo.rafael.naruto.help.desk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chamado")
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_chamado")
	private Long idChamado;

	@Column(name = "cliente")
	private Long cliente;

	@Column(name = "atendente")
	private Long atendente;

	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "data_termino")
	private Date dataTermino;

	@Column(name = "status")
	private Integer status;

	@Column(name = "setor")
	private Integer setor;

	@Column(name = "titulo")
	private String titulo;

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
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

}