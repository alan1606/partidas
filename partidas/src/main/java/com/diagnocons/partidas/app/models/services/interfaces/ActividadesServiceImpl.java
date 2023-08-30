package com.diagnocons.partidas.app.models.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diagnocons.partidas.app.models.entity.Actividad;
import com.diagnocons.partidas.app.models.services.implementations.ActividadService;

@Service
public class ActividadesServiceImpl implements ActividadService{

	
	@Override
	public List<Actividad> buscarPorPortafolio(Long portafolioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actividad guardarActividad(Actividad actividad) {
		// TODO Auto-generated method stub
		return null;
	}

}
