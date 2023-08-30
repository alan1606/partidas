package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Socio;

@RestController
@RequestMapping("socios")
public class SocioController {

	@PostMapping
	public ResponseEntity<Socio> crearSocio(@RequestBody Socio socio){
		return null;
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Socio>> buscarPorNombre(@PathVariable String nombre){
		return null;
	}
	
}
