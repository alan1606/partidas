package com.diagnocons.partidas.app.models.services.interfaces;

import java.util.List;

import com.diagnocons.partidas.app.models.entity.Proyecto;

public interface ProyectoService {
	List<Proyecto> buscarProyectosPorPortafolio(Long portafolioId);
}
