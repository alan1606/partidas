package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("portafolios")
public class PortafolioController {

	
	@GetMapping
	public ResponseEntity<List<Portafolio>> buscarTodoPaginable(Pageable pageable){
		return null;
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Portafolio>> buscarPortafoliosLikeNombre(@PathVariable String nombre){
		return null;
	}
	
	@PostMapping()
	public ResponseEntity<Portafolio> crearPortafolio(@RequestBody Portafolio portafolio){
		return null;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminarPortafolio(@PathVariable Long id){
		//Solo si no tiene relaciones lo elimina
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Portafolio> modificarPortafolio(@PathVariable Long id, @RequestBody Portafolio nuevo){
		return null;
	}
	
	
}
