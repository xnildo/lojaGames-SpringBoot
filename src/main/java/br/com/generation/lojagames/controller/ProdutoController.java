package br.com.generation.lojagames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.generation.lojagames.model.Produto;
import br.com.generation.lojagames.repository.ProdutoRepository;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository
				.findAllByNomeContainingIgnoreCase(nome));
		
	}
	
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<Produto>> getByMarca(@PathVariable String marca){
		return ResponseEntity.ok(produtoRepository
				.findAllByMarcaContainingIgnoreCase(marca));
		
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoRepository.save(nome));
		
	}
	
	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.OK)
				.body(produtoRepository.save(nome));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtoRepository.deleteById(id);
		
	}
	
}
