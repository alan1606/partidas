package com.diagnocons.partidas.app.models.services.interfaces;

import java.util.List;


import com.diagnocons.partidas.app.models.entity.Material;

public interface MaterialService {
	
	public Material crearMaterial(Material material);
	
	public List<Material> buscarPorNombre(String nombre);
	
}
