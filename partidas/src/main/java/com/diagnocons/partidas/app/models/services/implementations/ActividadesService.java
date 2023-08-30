package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;

import com.diagnocons.partidas.app.models.entity.Actividad;

public interface ActividadesService {
	
	public List<Actividad> buscarPorPortafolio(Long portafolioId);
	
	public Actividad guardarActividad(Actividad actividad);
}
