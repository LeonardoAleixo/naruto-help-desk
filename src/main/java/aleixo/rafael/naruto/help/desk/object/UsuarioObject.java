package aleixo.rafael.naruto.help.desk.object;

public class UsuarioObject {

	private Long idUsuario;
	private String nome;
	private String sobrenome;
	private Integer tipoUsuario;
	private Long empresa;
	private String email;
	private String senha;
	private Integer setor;
	private Boolean status;

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getSetor() {
		return this.setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}