package aleixo.rafael.naruto.help.desk.repository;

/*importações do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/*importações de tipagem e classes que serão utilizadas*/
import aleixo.rafael.naruto.help.desk.model.Plano;
import java.util.List;

@Repository
public interface PlanoRepository extends CrudRepository<Plano, Integer>{

	@Query("SELECT p FROM Plano p")
	List<Plano> encontrarTodos();

	@Query("SELECT p FROM Plano p WHERE p.nome LIKE :nome")
	List<Plano> encontrarPorNomeLike(@Param("nome") String nome);

	@Query("SELECT p FROM Plano p WHERE p.nome = :nome")
	List<Plano> encontrarPorNomeEqual(@Param("nome") String nome);

	@Query("SELECT p FROM Plano p WHERE p.quantidadeChamadoMes > :quantidade_chamado_mes")
	List<Plano> encontrarPorQuantidadeChamadoMesMaiorQue(@Param("quantidade_chamado_mes") Integer quantidadeChamadoMes);

	@Query("SELECT p FROM Plano p WHERE p.quantidadeChamadoMes > :quantidade_chamado_mes")
	List<Plano> encontrarPorQuantidadeChamadoMesMenorQue(@Param("quantidade_chamado_mes") Integer quantidadeChamadoMes);

	@Query("SELECT p FROM Plano p WHERE p.quantidadeChamadoMes >= :quantidade_chamado_mes")
	List<Plano> encontrarPorQuantidadeChamadoMesMaiorIgualQue(@Param("quantidade_chamado_mes") Integer quantidadeChamadoMes);

	@Query("SELECT p FROM Plano p WHERE p.quantidadeChamadoMes <= :quantidade_chamado_mes")
	List<Plano> encontrarPorQuantidadeChamadoMesMenorIgualQue(@Param("quantidade_chamado_mes") Integer quantidadeChamadoMes);

	@Query("SELECT p FROM Plano p WHERE p.quantidadeChamadoMes = :quantidade_chamado_mes")
	List<Plano> encontrarPorQuantidadeChamadoMesEqual(@Param("quantidade_chamado_mes") Integer quantidadeChamadoMes);


}