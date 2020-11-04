package aleixo.rafael.naruto.help.desk.object;

public class SetorObject {

	private Integer idSetor;
	private String nome;
	private Boolean status;

	public Integer getIdSetor(){
		return this.idSetor; 
	}
	public void setIdSetor(Integer idSetor){
		this.idSetor = idSetor;
	}

	public String getNome(){
		return this.nome; 
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	

}