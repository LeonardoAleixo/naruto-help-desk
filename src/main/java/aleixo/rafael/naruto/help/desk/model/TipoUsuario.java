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
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable {

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_tipo_usuario")
	private Integer idTipoUsuario;

	@Column(name = "nome")
	private String nome;

	public Integer getIdTipoUsuario(){
		return this.idTipoUsuario; 
	}
	public void setIdTipoUsuario(Integer idTipoUsuario){
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNome(){
		return this.nome; 
	}
	public void setNome(String nome){
		this.nome = nome;
	}

}