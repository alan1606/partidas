package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diagnocons.partidas.app.models.entity.Actividad;
import com.diagnocons.partidas.app.models.entity.ActividadMaterial;
import com.diagnocons.partidas.app.models.entity.ActividadSocio;
import com.diagnocons.partidas.app.models.repository.ActividadMaterialRepository;
import com.diagnocons.partidas.app.models.repository.ActividadRepository;
import com.diagnocons.partidas.app.models.repository.ActividadSocioRepository;
import com.diagnocons.partidas.app.models.services.interfaces.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService{

	private ActividadRepository actividadRepository;
	private ActividadSocioRepository actividadSocioRepository;
	private ActividadMaterialRepository actividadMaterialRepository;
	
	public ActividadServiceImpl(
			ActividadRepository actividadRepository,
			ActividadSocioRepository actividadSocioRepository,
			ActividadMaterialRepository actividadMaterialRepository
	) {
		this.actividadRepository = actividadRepository;
		this.actividadSocioRepository = actividadSocioRepository;
		this.actividadMaterialRepository = actividadMaterialRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> buscarPorProyecto(Long proyectoId) {
		return actividadRepository.buscarPorProyecto(proyectoId);
	}

	@Override
	@Transactional
	public Actividad guardarActividad(Actividad actividad) {
		Actividad resultado = actividadRepository.save(actividad);
		
		List<ActividadMaterial> materiales = 
				resultado.getMateriales()
				.stream()
				.map(material -> new ActividadMaterial(resultado, material))
				.collect(Collectors.toList());
		
		List<ActividadSocio> socios =
				resultado.getSocios()
				.stream()
				.map(socio -> new ActividadSocio(resultado, socio))
				.collect(Collectors.toList());
		
		actividadMaterialRepository.saveAll(materiales);
		actividadSocioRepository.saveAll(socios);
		
		return resultado;
	}

}
