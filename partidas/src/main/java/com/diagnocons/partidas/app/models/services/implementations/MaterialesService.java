package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;


import com.diagnocons.partidas.app.models.entity.Material;

public interface MaterialesService {
	
	public Material crearMaterial(Material material);
	
	public List<Material> buscarPorNombre(String nombre);
	
}
