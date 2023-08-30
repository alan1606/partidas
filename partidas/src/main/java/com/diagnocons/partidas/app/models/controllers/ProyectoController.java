package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Proyecto;
import com.diagnocons.partidas.app.models.services.interfaces.ProyectoService;

@RestController
@RequestMapping("proyectos")
public class ProyectoController {

	private ProyectoService proyectoService;
	
	public ProyectoController(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	
	@GetMapping("/portafolio/{portafolioId}")
	public ResponseEntity<List<Proyecto>> buscarProyectosPorPortafolio(Long portafolioId){
		return ResponseEntity
				.ok(
					proyectoService.buscarProyectosPorPortafolio(portafolioId)
				);
	}
	
}
