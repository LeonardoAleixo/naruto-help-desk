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
@Table(name = "setor")
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_setor")
	private Integer idSetor;

	@Column(name = "nome")
	private String nome;

	@Column(name = "status")
	private Boolean status;

	public Integer getIdSetor() {
		return this.idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}