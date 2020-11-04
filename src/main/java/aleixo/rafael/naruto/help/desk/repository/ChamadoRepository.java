package aleixo.rafael.naruto.help.desk.repository;

import java.util.Date;
import java.util.List;

/*importa��es do spring*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*importa��es de tipagem e classes que ser�o utilizadas*/
import aleixo.rafael.naruto.help.desk.model.Chamado;


@Repository
public interface ChamadoRepository extends CrudRepository<Chamado, Long>{

	@Query("SELECT c FROM Chamado c")
	List<Chamado> encontrarTodos();

	@Query("SELECT c FROM Chamado c WHERE c.dataInicio > :data_inicio")
	List<Chamado> encontrarPorDataInicioMaiorQue(@Param("data_inicio") Date dataInicio);

	@Query("SELECT c FROM Chamado c WHERE c.dataInicio > :data_inicio")
	List<Chamado> encontrarPorDataInicioMenorQue(@Param("data_inicio") Date dataInicio);

	@Query("SELECT c FROM Chamado c WHERE c.dataInicio >= :data_inicio")
	List<Chamado> encontrarPorDataInicioMaiorIgualQue(@Param("data_inicio") Date dataInicio);

	@Query("SELECT c FROM Chamado c WHERE c.dataInicio <= :data_inicio")
	List<Chamado> encontrarPorDataInicioMenorIgualQue(@Param("data_inicio") Date dataInicio);

	@Query("SELECT c FROM Chamado c WHERE c.dataInicio = :data_inicio")
	List<Chamado> encontrarPorDataInicioEqual(@Param("data_inicio") Date dataInicio);

	@Query("SELECT c FROM Chamado c WHERE c.dataTermino > :data_termino")
	List<Chamado> encontrarPorDataTerminoMaiorQue(@Param("data_termino") Date dataTermino);

	@Query("SELECT c FROM Chamado c WHERE c.dataTermino > :data_termino")
	List<Chamado> encontrarPorDataTerminoMenorQue(@Param("data_termino") Date dataTermino);

	@Query("SELECT c FROM Chamado c WHERE c.dataTermino >= :data_termino")
	List<Chamado> encontrarPorDataTerminoMaiorIgualQue(@Param("data_termino") Date dataTermino);

	@Query("SELECT c FROM Chamado c WHERE c.dataTermino <= :data_termino")
	List<Chamado> encontrarPorDataTerminoMenorIgualQue(@Param("data_termino") Date dataTermino);

	@Query("SELECT c FROM Chamado c WHERE c.dataTermino = :data_termino")
	List<Chamado> encontrarPorDataTerminoEqual(@Param("data_termino") Date dataTermino);

	@Query("SELECT c FROM Chamado c WHERE c.status > :status")
	List<Chamado> encontrarPorStatusMaiorQue(@Param("status") Integer status);

	@Query("SELECT c FROM Chamado c WHERE c.status > :status")
	List<Chamado> encontrarPorStatusMenorQue(@Param("status") Integer status);

	@Query("SELECT c FROM Chamado c WHERE c.status >= :status")
	List<Chamado> encontrarPorStatusMaiorIgualQue(@Param("status") Integer status);

	@Query("SELECT c FROM Chamado c WHERE c.status <= :status")
	List<Chamado> encontrarPorStatusMenorIgualQue(@Param("status") Integer status);

	@Query("SELECT c FROM Chamado c WHERE c.status = :status")
	List<Chamado> encontrarPorStatusEqual(@Param("status") Integer status);

	@Query("SELECT c FROM Chamado c WHERE c.setor > :setor")
	List<Chamado> encontrarPorSetorMaiorQue(@Param("setor") Integer setor);

	@Query("SELECT c FROM Chamado c WHERE c.setor > :setor")
	List<Chamado> encontrarPorSetorMenorQue(@Param("setor") Integer setor);

	@Query("SELECT c FROM Chamado c WHERE c.setor >= :setor")
	List<Chamado> encontrarPorSetorMaiorIgualQue(@Param("setor") Integer setor);

	@Query("SELECT c FROM Chamado c WHERE c.setor <= :setor")
	List<Chamado> encontrarPorSetorMenorIgualQue(@Param("setor") Integer setor);

	@Query("SELECT c FROM Chamado c WHERE c.setor = :setor")
	List<Chamado> encontrarPorSetorEqual(@Param("setor") Integer setor);

	@Query("SELECT c FROM Chamado c WHERE c.titulo LIKE :titulo")
	List<Chamado> encontrarPorTituloLike(@Param("titulo") String titulo);

	@Query("SELECT c FROM Chamado c WHERE c.titulo = :titulo")
	List<Chamado> encontrarPorTituloEqual(@Param("titulo") String titulo);


}