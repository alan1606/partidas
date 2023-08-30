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

import com.diagnocons.partidas.app.models.entity.Material;
import com.diagnocons.partidas.app.models.services.interfaces.MaterialService;

@RestController
@RequestMapping("materiales")
public class MaterialesController {

	private MaterialService materialService;
	
	public MaterialesController(MaterialService materialService) {
		this.materialService = materialService;
	}

	@PostMapping
	public ResponseEntity<Material> crearMaterial(@RequestBody Material material){
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
