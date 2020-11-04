package aleixo.rafael.naruto.help.desk.repository;

/*importa��es do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/*importa��es de tipagem e classes que ser�o utilizadas*/
import aleixo.rafael.naruto.help.desk.model.Empresa;
import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

	@Query("SELECT e FROM Empresa e")
	List<Empresa> encontrarTodos();

	@Query("SELECT e FROM Empresa e WHERE e.nome LIKE :nome")
	List<Empresa> encontrarPorNomeLike(@Param("nome") String nome);

	@Query("SELECT e FROM Empresa e WHERE e.nome = :nome")
	List<Empresa> encontrarPorNomeEqual(@Param("nome") String nome);

	@Query("SELECT e FROM Empresa e WHERE e.plano > :plano")
	List<Empresa> encontrarPorPlanoMaiorQue(@Param("plano") Integer plano);

	@Query("SELECT e FROM Empresa e WHERE e.plano > :plano")
	List<Empresa> encontrarPorPlanoMenorQue(@Param("plano") Integer plano);

	@Query("SELECT e FROM Empresa e WHERE e.plano >= :plano")
	List<Empresa> encontrarPorPlanoMaiorIgualQue(@Param("plano") Integer plano);

	@Query("SELECT e FROM Empresa e WHERE e.plano <= :plano")
	List<Empresa> encontrarPorPlanoMenorIgualQue(@Param("plano") Integer plano);

	@Query("SELECT e FROM Empresa e WHERE e.plano = :plano")
	List<Empresa> encontrarPorPlanoEqual(@Param("plano") Integer plano);


}