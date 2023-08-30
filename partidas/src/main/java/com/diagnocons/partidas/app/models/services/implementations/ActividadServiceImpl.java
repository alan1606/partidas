package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diagnocons.partidas.app.models.entity.Actividad;
import com.diagnocons.partidas.app.models.repository.ActividadRepository;
import com.diagnocons.partidas.app.models.services.interfaces.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService{

	private ActividadRepository actividadRepository;
	
	public ActividadServiceImpl(ActividadRepository actividadRepository) {
		this.actividadRepository = actividadRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> buscarPorProyecto(Long proyectoId) {
		return actividadRepository.buscarPorProyecto(proyectoId);
	}

	@Override
	@Transactional
	public Actividad guardarActividad(Actividad actividad) {
		return actividadRepository.save(actividad);
	}

}
