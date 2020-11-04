package aleixo.rafael.naruto.help.desk.repository;

/*importa��es do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/*importa��es de tipagem e classes que ser�o utilizadas*/
import aleixo.rafael.naruto.help.desk.model.HistoricoChamado;
import java.util.List;
import java.util.Date;


@Repository
public interface HistoricoChamadoRepository extends CrudRepository<HistoricoChamado, Long>{

	@Query("SELECT h FROM HistoricoChamado h")
	List<HistoricoChamado> encontrarTodos();

	@Query("SELECT h FROM HistoricoChamado h WHERE h.descricao LIKE :descricao")
	List<HistoricoChamado> encontrarPorDescricaoLike(@Param("descricao") String descricao);

	@Query("SELECT h FROM HistoricoChamado h WHERE h.descricao = :descricao")
	List<HistoricoChamado> encontrarPorDescricaoEqual(@Param("descricao") String descricao);

	@Query("SELECT h FROM HistoricoChamado h WHERE h.data > :data")
	List<HistoricoChamado> encontrarPorDataMaiorQue(@Param("data") Date data);

	@Query("SELECT h FROM HistoricoChamado h WHERE h.data > :data")
	List<HistoricoChamado> encontrarPorDataMenorQue(@Param("data") Date data);

	@Query("SELECT h FROM HistoricoChamado h WHERE h.data >= :data")
	List<HistoricoChamado> encontrarPorDataMaiorIgualQue(@Param("data") Date data);

	@Query("SELECT h FROM HistoricoChamado h WHERE h.data <= :data")
	List<HistoricoChamado> encontrarPorDataMenorIgualQue(@Param("data") Date data);

	@Query("SELECT h FROM HistoricoChamado h WHERE h.data = :data")
	List<HistoricoChamado> encontrarPorDataEqual(@Param("data") Date data);


}