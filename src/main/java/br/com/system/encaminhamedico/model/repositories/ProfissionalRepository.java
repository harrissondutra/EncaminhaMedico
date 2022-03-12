package br.com.system.encaminhamedico.model.repositories;

import br.com.system.encaminhamedico.model.entities.Profissional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProfissionalRepository extends PagingAndSortingRepository<Profissional, Integer> {

	@Query("SELECT p FROM Profissional p WHERE p.nome LIKE %:nome%")
	public Iterable<Profissional> searchByNameLike(@Param("nome") String nome);

}
