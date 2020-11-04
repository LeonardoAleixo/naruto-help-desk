package aleixo.rafael.naruto.help.desk.repository;

/*importações do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/*importações de tipagem e classes que serão utilizadas*/
import aleixo.rafael.naruto.help.desk.model.Setor;
import java.util.List;

@Repository
public interface SetorRepository extends CrudRepository<Setor, Integer>{

	@Query("SELECT s FROM Setor s")
	List<Setor> encontrarTodos();

	@Query("SELECT s FROM Setor s WHERE s.nome LIKE :nome")
	List<Setor> encontrarPorNomeLike(@Param("nome") String nome);

	@Query("SELECT s FROM Setor s WHERE s.nome = :nome")
	List<Setor> encontrarPorNomeEqual(@Param("nome") String nome);


}