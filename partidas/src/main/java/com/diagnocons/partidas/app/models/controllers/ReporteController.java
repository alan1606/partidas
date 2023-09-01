package com.diagnocons.partidas.app.models.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnocons.partidas.app.models.entity.Portafolio;
import com.diagnocons.partidas.app.models.services.interfaces.ReporteService;

@RestController
@RequestMapping("reportes")
public class ReporteController {

	private ReporteService reporteService;
	
	public ReporteController(ReporteService reporteService) {
		this.reporteService = reporteService;
	}
	
	@GetMapping("/portafolio/{portafolioId}")
	public ResponseEntity<Portafolio> obtenerReporteDeProyectos(@PathVariable Long portafolioId){
		Portafolio portafolio = null;
		portafolio = reporteService.obtenerReporteDeProyectosPorPortafolio(portafolioId);
		return ResponseEntity.ok(portafolio);
	}
	
	
}
