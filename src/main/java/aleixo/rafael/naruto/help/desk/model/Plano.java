package aleixo.rafael.naruto.help.desk.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plano")
public class Plano implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_plano")
	private Integer idPlano;

	@Column(name = "nome")
	private String nome;

	@Column(name = "quantidade_chamado_mes")
	private Integer quantidadeChamadoMes;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "icone")
	private String icone;

	public Integer getIdPlano() {
		return this.idPlano;
	}

	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeChamadoMes() {
		return this.quantidadeChamadoMes;
	}

	public void setQuantidadeChamadoMes(Integer quantidadeChamadoMes) {
		this.quantidadeChamadoMes = quantidadeChamadoMes;
	}

	public Double getValor() {
		return this.valor;
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