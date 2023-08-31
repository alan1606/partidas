package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Socio;
import com.diagnocons.partidas.app.models.services.interfaces.SocioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("socios")
public class SocioController {

	private SocioService socioService;
	private Validador validador;
	
	public SocioController(
			SocioService socioService,
			Validador validador
		) {
		this.socioService = socioService;
		this.validador = validador;
	}

	@PostMapping
	public ResponseEntity<Socio> crearSocio(@Valid @RequestBody Socio socio, BindingResult result){
		if(result.hasErrors()) {
			validador.validar(result);
		}
		
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
