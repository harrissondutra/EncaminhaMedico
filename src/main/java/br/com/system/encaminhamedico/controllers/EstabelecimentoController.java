package br.com.system.encaminhamedico.controllers;

import java.util.Optional;
import br.com.system.encaminhamedico.model.entities.Estabelecimento;
import br.com.system.encaminhamedico.model.repositories.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@CrossOrigin("*")
@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	public EstabelecimentoRepository estabelecimentoRepository;

	@RequestMapping
	public Iterable<Estabelecimento> bucaEstabelecimento() {
		return estabelecimentoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Estabelecimento> buscaEstabelecimentoPorID(@PathVariable int id) {
		return estabelecimentoRepository.findById(id);
	}

	@GetMapping(path = "/estabelecimento/{nomeEstabelecimento}")
	public Iterable<Estabelecimento> buscaEstabelecimentoPorNome(@PathVariable String nomeEstabelecimento) {
		return estabelecimentoRepository.searchByNameLike(nomeEstabelecimento);
	}

	@GetMapping("/estabelecimento/{numeroPagina}/{qtdePagina}")
	public Iterable<Estabelecimento> buscaEstabelecimentoPorPagina(@PathVariable int numeroPagina,
			@PathVariable int qtdePagina) {
		if (numeroPagina >= 5) {
			numeroPagina = 5;
		}
		Pageable page = PageRequest.of(numeroPagina, 20);
		return estabelecimentoRepository.findAll(page);
	}

	@PostMapping
	public @ResponseBody Estabelecimento salvaEstabelecimento(@Valid Estabelecimento estabelecimento) {
		estabelecimentoRepository.save(estabelecimento);
		return estabelecimento;
	}

	@PutMapping
	public Estabelecimento alteraEstabelecimento(@Valid Estabelecimento estabelecimento){
		estabelecimentoRepository.save(estabelecimento);
		return estabelecimento;
	}

	@DeleteMapping("{id}")
	public void apagarEstabelecimento(@PathVariable int id) {
		estabelecimentoRepository.deleteById(id);
	}
}
