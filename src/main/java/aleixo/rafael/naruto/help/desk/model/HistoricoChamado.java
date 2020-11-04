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
@Table(name = "historico_chamado")
public class HistoricoChamado implements Serializable {

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_historico_chamado")
	private Integer idHistoricoChamado;

	@Column(name = "usuario")
	private Long usuario;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "data")
	private Date data;

	@Column(name = "chamado")
	private Long chamado;

	public Integer getIdHistoricoChamado(){
		return this.idHistoricoChamado; 
	}
	public void setIdHistoricoChamado(Integer idHistoricoChamado){
		this.idHistoricoChamado = idHistoricoChamado;
	}

	public Long getUsuario(){
		return this.usuario; 
	}
	public void setUsuario(Long usuario){
		this.usuario = usuario;
	}

	public String getDescricao(){
		return this.descricao; 
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getChamado(){
		return this.chamado; 
	}
	public void setChamado(Long chamado){
		this.chamado = chamado;
	}

}