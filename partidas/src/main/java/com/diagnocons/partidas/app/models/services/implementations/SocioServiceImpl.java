package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diagnocons.partidas.app.models.entity.Socio;
import com.diagnocons.partidas.app.models.repository.SocioRepository;
import com.diagnocons.partidas.app.models.services.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService{

	private SocioRepository socioRepository;

	public SocioServiceImpl(SocioRepository socioRepository) {
		this.socioRepository = socioRepository;
	}
	
	@Override
	public Socio crearSocio(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public List<Socio> buscarPorNombre(String nombre) {
		return socioRepository.buscarPorNombre(nombre);
	}

	
	
}
