package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Socio;
import com.diagnocons.partidas.app.models.services.interfaces.SocioService;

@RestController
@RequestMapping("socios")
public class SocioController {

	private SocioService socioService;
	
	public SocioController(SocioService socioService) {
		this.socioService = socioService;
	}

	@PostMapping
	public ResponseEntity<Socio> crearSocio(@RequestBody Socio socio){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(socioService.crearSocio(socio));
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Socio>> buscarPorNombre(@PathVariable String nombre){
		return ResponseEntity
				.ok(socioService.buscarPorNombre(nombre));
	}
	
}
