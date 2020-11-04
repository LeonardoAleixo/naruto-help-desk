package aleixo.rafael.naruto.help.desk.repository;

/*importações do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/*importações de tipagem e classes que serão utilizadas*/
import aleixo.rafael.naruto.help.desk.model.TipoUsuario;
import java.util.List;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Integer>{

	@Query("SELECT t FROM TipoUsuario t")
	List<TipoUsuario> encontrarTodos();

	@Query("SELECT t FROM TipoUsuario t WHERE t.nome LIKE :nome")
	List<TipoUsuario> encontrarPorNomeLike(@Param("nome") String nome);

	@Query("SELECT t FROM TipoUsuario t WHERE t.nome = :nome")
	List<TipoUsuario> encontrarPorNomeEqual(@Param("nome") String nome);


}