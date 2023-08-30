package com.diagnocons.partidas.app.models.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Proyecto;

@RestController
@RequestMapping("proyectos")
public class ProyectoController {

	@GetMapping("/portafolio/{portafolioId}")
	public ResponseEntity<List<Proyecto>> buscarProyectosPorPortafolio(Long portafolioId){
		return null;
	}
	
}
