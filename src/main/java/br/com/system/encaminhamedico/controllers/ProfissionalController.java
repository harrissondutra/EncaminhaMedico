package br.com.system.encaminhamedico.controllers;

import java.util.Optional;

import javax.validation.Valid;

import br.com.system.encaminhamedico.model.entities.Profissional;
import br.com.system.encaminhamedico.model.repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

	@Autowired
	private ProfissionalRepository profissionalRepository;


	@RequestMapping
	public Iterable<Profissional> obterProfissional() {
		return profissionalRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Profissional> obteProfissionalPorID(@PathVariable int id) {
		return profissionalRepository.findById(id);
	}

	@GetMapping(path = "/profissional/{nome}")
	public Iterable<Profissional> obterProfissionalPorNome(@PathVariable String parteNome) {
		return profissionalRepository.searchByNameLike(parteNome);
	}

	@GetMapping("/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Profissional> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5) {
			qtdePagina = 5;
		}
		Pageable page = PageRequest.of(numeroPagina, 20);
		return profissionalRepository.findAll(page);
	}

	@PostMapping
	public @ResponseBody
	Profissional salvarProfissional(@Valid Profissional profissional) {
		profissionalRepository.save(profissional);
		return profissional;
	}

	@PutMapping
	public Profissional alteraProfissional(@Valid Profissional profissional){
		profissionalRepository.save(profissional);
		return profissional;
	}

	@DeleteMapping("/{id}")
	public void excluirProfissional(@PathVariable int id) {
		profissionalRepository.deleteById(id);
	}

}
