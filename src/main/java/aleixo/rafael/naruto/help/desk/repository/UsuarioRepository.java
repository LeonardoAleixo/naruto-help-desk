package aleixo.rafael.naruto.help.desk.repository;

import java.util.List;
import java.util.Optional;

/*importa��es do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*importa��es de tipagem e classes que ser�o utilizadas*/
import aleixo.rafael.naruto.help.desk.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u")
	List<Usuario> encontrarTodos();

	@Query("SELECT u FROM Usuario u WHERE u.nome LIKE :nome")
	List<Usuario> encontrarPorNomeLike(@Param("nome") String nome);

	@Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
	List<Usuario> encontrarPorNomeEqual(@Param("nome") String nome);

	@Query("SELECT u FROM Usuario u WHERE u.sobrenome LIKE :sobrenome")
	List<Usuario> encontrarPorSobrenomeLike(@Param("sobrenome") String sobrenome);

	@Query("SELECT u FROM Usuario u WHERE u.sobrenome = :sobrenome")
	List<Usuario> encontrarPorSobrenomeEqual(@Param("sobrenome") String sobrenome);

	@Query("SELECT u FROM Usuario u WHERE u.tipoUsuario > :tipo_usuario")
	List<Usuario> encontrarPorTipoUsuarioMaiorQue(@Param("tipo_usuario") Integer tipoUsuario);

	@Query("SELECT u FROM Usuario u WHERE u.tipoUsuario > :tipo_usuario")
	List<Usuario> encontrarPorTipoUsuarioMenorQue(@Param("tipo_usuario") Integer tipoUsuario);

	@Query("SELECT u FROM Usuario u WHERE u.tipoUsuario >= :tipo_usuario")
	List<Usuario> encontrarPorTipoUsuarioMaiorIgualQue(@Param("tipo_usuario") Integer tipoUsuario);

	@Query("SELECT u FROM Usuario u WHERE u.tipoUsuario <= :tipo_usuario")
	List<Usuario> encontrarPorTipoUsuarioMenorIgualQue(@Param("tipo_usuario") Integer tipoUsuario);

	@Query("SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipo_usuario")
	List<Usuario> encontrarPorTipoUsuarioEqual(@Param("tipo_usuario") Integer tipoUsuario);

	@Query("SELECT u FROM Usuario u WHERE u.email LIKE :email")
	List<Usuario> encontrarPorEmailLike(@Param("email") String email);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> encontrarPorEmailEqual(@Param("email") String email);

	@Query("SELECT u FROM Usuario u WHERE u.senha LIKE :senha")
	List<Usuario> encontrarPorSenhaLike(@Param("senha") String senha);

	@Query("SELECT u FROM Usuario u WHERE u.senha = :senha")
	List<Usuario> encontrarPorSenhaEqual(@Param("senha") String senha);

	@Query("SELECT u FROM Usuario u WHERE u.setor > :setor")
	List<Usuario> encontrarPorSetorMaiorQue(@Param("setor") Integer setor);

	@Query("SELECT u FROM Usuario u WHERE u.setor > :setor")
	List<Usuario> encontrarPorSetorMenorQue(@Param("setor") Integer setor);

	@Query("SELECT u FROM Usuario u WHERE u.setor >= :setor")
	List<Usuario> encontrarPorSetorMaiorIgualQue(@Param("setor") Integer setor);

	@Query("SELECT u FROM Usuario u WHERE u.setor <= :setor")
	List<Usuario> encontrarPorSetorMenorIgualQue(@Param("setor") Integer setor);

	@Query("SELECT u FROM Usuario u WHERE u.setor = :setor")
	List<Usuario> encontrarPorSetorEqual(@Param("setor") Integer setor);

	@Query("SELECT u FROM Usuario u WHERE u.empresa = :empresa")
	List<Usuario> encontrarPorEmpresaEqual(@Param("empresa") Long empresa);

}