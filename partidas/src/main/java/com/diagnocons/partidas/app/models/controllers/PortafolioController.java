package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Portafolio;
import com.diagnocons.partidas.app.models.services.interfaces.PortafolioService;

@RestController
@RequestMapping("portafolios")
public class PortafolioController {

	private PortafolioService portafolioService;
	
	
	public PortafolioController(PortafolioService portafolioService) {
		this.portafolioService = portafolioService;
	}

	@GetMapping
	public ResponseEntity<Page<Portafolio>> buscarTodoPaginable(Pageable pageable){
		return ResponseEntity.ok(
					portafolioService.buscarTodoPaginable(pageable)
				);
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Portafolio>> buscarPortafoliosLikeNombre(@PathVariable String nombre){
		return ResponseEntity.ok(
					portafolioService.buscarPortafoliosLikeNombre(nombre)
				);
	}
	
	@PostMapping()
	public ResponseEntity<Portafolio> crearPortafolio(@RequestBody Portafolio portafolio){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(
					portafolioService.crearPortafolio(portafolio)
				);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminarPortafolio(@PathVariable Long id){
		try {
			portafolioService.eliminarPortafolio(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Portafolio> modificarPortafolio(@PathVariable Long id, @RequestBody Portafolio nuevo){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(portafolioService.modificarPortafolio(id, nuevo));
	}
	
	
}
