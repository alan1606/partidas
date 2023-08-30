package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diagnocons.partidas.app.models.entity.Material;
import com.diagnocons.partidas.app.models.repository.MaterialRepository;
import com.diagnocons.partidas.app.models.services.interfaces.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService{

	private MaterialRepository materialRepository;
	
	public MaterialServiceImpl(MaterialRepository materialRepository) {
		this.materialRepository = materialRepository;
	}
	
	@Override
	@Transactional
	public Material crearMaterial(Material material) {
		return materialRepository.save(material);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Material> buscarPorNombre(String nombre) {
		return materialRepository.buscarPorNombre(nombre);
	}

}
