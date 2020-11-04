package aleixo.rafael.naruto.help.desk.object;

public class GenericoObject {

	private Integer id;
	private Boolean status;
	private String descricao;
	
	public GenericoObject() {
		
	}
	
	public GenericoObject(Integer id) {
		this.id = id;
	}
	
	public GenericoObject(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public Integer getId(){
		return this.id; 
	}
	public void setId(Integer id){
		this.id = id;
	}

	public Boolean getStatus(){
		return this.status; 
	}
	public void setStatus(Boolean status){
		this.status = status;
	}

	public String getDescricao(){
		return this.descricao; 
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}

}