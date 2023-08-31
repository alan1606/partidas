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

import com.diagnocons.partidas.app.models.entity.Actividad;
import com.diagnocons.partidas.app.models.services.interfaces.ActividadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("actividades")
public class ActividadesController {
	
	private ActividadService actividadService;
	private Validador validador;
	
	public ActividadesController(
			ActividadService actividadService,
			Validador validador
		){
		this.actividadService = actividadService;
		this.validador = validador;
	}
	
	@GetMapping("/proyecto/{proyectoId}")
	public ResponseEntity<List<Actividad>> buscarPorProyecto(@PathVariable Long proyectoId){
		return ResponseEntity.ok(
				actividadService.buscarPorProyecto(proyectoId)
				);
	}
	
	
	@PostMapping()
	public ResponseEntity<?> guardarActividad(@Valid @RequestBody Actividad actividad, BindingResult result){
		if(result.hasErrors()) {
			return validador.validar(result);
		}
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(
				actividadService.guardarActividad(actividad)
				);
	}
	
}
