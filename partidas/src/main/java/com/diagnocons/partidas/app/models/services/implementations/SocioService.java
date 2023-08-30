package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;

import com.diagnocons.partidas.app.models.entity.Socio;

public interface SocioService {
	
	public Socio crearSocio(Socio socio);

	public List<Socio> buscarPorNombre(String nombre);

}
