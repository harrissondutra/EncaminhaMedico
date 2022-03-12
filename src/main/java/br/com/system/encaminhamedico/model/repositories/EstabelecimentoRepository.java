package br.com.system.encaminhamedico.model.repositories;


import br.com.system.encaminhamedico.model.entities.Estabelecimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface EstabelecimentoRepository extends PagingAndSortingRepository<Estabelecimento, Integer> {

	@Query("select e from Estabelecimento e where e.nome Like %:nome%")
	public Iterable<Estabelecimento> searchByNameLike(@Param("nome") String nome);

}
