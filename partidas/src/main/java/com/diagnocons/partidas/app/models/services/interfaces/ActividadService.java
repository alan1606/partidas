package com.diagnocons.partidas.app.models.services.interfaces;

import java.util.List;

import com.diagnocons.partidas.app.models.entity.Actividad;

public interface ActividadService {
	
	public List<Actividad> buscarPorProyecto(Long proyectoId);
	
	public Actividad guardarActividad(Actividad actividad);
}
