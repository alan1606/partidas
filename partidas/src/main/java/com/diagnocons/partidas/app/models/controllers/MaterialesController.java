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

import com.diagnocons.partidas.app.models.entity.Material;
import com.diagnocons.partidas.app.models.services.interfaces.MaterialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("materiales")
public final class MaterialesController {

	private MaterialService materialService;
	private Validador validador;
	
	public MaterialesController(
			MaterialService materialService,
			Validador validador
			) {
		this.materialService = materialService;
		this.validador = validador;
	}

	@PostMapping
	public ResponseEntity<?> crearMaterial(@Valid @RequestBody Material material, BindingResult result){
		if(result.hasErrors()) {
			return validador.validar(result);
		}
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(
					materialService.crearMaterial(material)
				);
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Material>> buscarPorNombre(@PathVariable String nombre){
		return ResponseEntity.ok(
					materialService.buscarPorNombre(nombre)
				);
	}
}
