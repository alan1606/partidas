package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diagnocons.partidas.app.models.entity.Portafolio;
import com.diagnocons.partidas.app.models.entity.Proyecto;
import com.diagnocons.partidas.app.models.repository.PortafolioRepository;
import com.diagnocons.partidas.app.models.repository.ProyectoRepository;
import com.diagnocons.partidas.app.models.services.interfaces.PortafolioService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PortafolioServiceImpl implements PortafolioService{

	private PortafolioRepository portafolioRepository;
	private ProyectoRepository proyectoRepository;
	
	public PortafolioServiceImpl(
			PortafolioRepository portafolioRepository,
			ProyectoRepository proyectoRepository
	) {
		this.portafolioRepository = portafolioRepository;
		this.proyectoRepository = proyectoRepository;
	}
	

	@Override
	@Transactional
	public Portafolio crearPortafolio(Portafolio portafolio) {
		return portafolioRepository.save(portafolio);
	}

	@Override
	@Transactional
	public void eliminarPortafolio(Long id) throws Exception {
		List<Proyecto> proyectos = proyectoRepository.encontrarPorPortafolio(id);
		if(proyectos.size() > 0) {
			throw new Exception("No se puede eliminar un portafolio que contiene proyectos");
		}
		portafolioRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Portafolio modificarPortafolio(Long id, Portafolio nuevo) {
		Optional<Portafolio> o = portafolioRepository.findById(id);
		if(o.isEmpty()) {
			throw new EntityNotFoundException();
		}
		Portafolio db = o.get();
		db.setNombre(nuevo.getNombre());
		return portafolioRepository.save(db);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Portafolio> buscarTodoPaginable(Pageable pageable) {
		return portafolioRepository.findAll(pageable);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Portafolio> buscarPortafoliosLikeNombre(String nombre) {
		return portafolioRepository.buscarPorNombre(nombre);
	}

	
	
}
