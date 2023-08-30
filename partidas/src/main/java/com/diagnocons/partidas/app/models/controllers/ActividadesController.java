package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Actividad;

@RestController
@RequestMapping("actividades")
public class ActividadesController {
	
	@GetMapping("/portafolio/{portafolioId}")
	public ResponseEntity<List<Actividad>> buscarPorPortafolio(@PathVariable Long portafolioId){
		return null;
	}
	
	
	@PostMapping()
	public ResponseEntity<Actividad> guardarActividad(@RequestBody Actividad actividad){
		return null;
	}
}
