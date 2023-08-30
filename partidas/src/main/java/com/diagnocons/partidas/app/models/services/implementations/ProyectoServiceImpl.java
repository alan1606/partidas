package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diagnocons.partidas.app.models.entity.Proyecto;
import com.diagnocons.partidas.app.models.repository.ProyectoRepository;
import com.diagnocons.partidas.app.models.services.interfaces.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService{

	private ProyectoRepository proyectoRepository;
	
	public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
		this.proyectoRepository = proyectoRepository;
	}
	
	@Override
	public List<Proyecto> buscarProyectosPorPortafolio(Long portafolioId) {
		return proyectoRepository.encontrarPorPortafolio(portafolioId);
	}

}
