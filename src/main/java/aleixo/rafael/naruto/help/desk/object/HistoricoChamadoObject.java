package aleixo.rafael.naruto.help.desk.object;

public class HistoricoChamadoObject {

	private Integer idHistoricoChamado;
	private Long usuario;
	private String descricao;
	private Long data;
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

	public Long getData(){
		return this.data; 
	}
	public void setData(Long data){
		this.data = data;
	}

	public Long getChamado(){
		return this.chamado; 
	}
	public void setChamado(Long chamado){
		this.chamado = chamado;
	}

}