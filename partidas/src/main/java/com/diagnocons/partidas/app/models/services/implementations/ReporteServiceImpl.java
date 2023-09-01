package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diagnocons.partidas.app.models.entity.Material;
import com.diagnocons.partidas.app.models.entity.Portafolio;
import com.diagnocons.partidas.app.models.entity.Proyecto;
import com.diagnocons.partidas.app.models.entity.Socio;
import com.diagnocons.partidas.app.models.repository.ActividadMaterialRepository;
import com.diagnocons.partidas.app.models.repository.ActividadRepository;
import com.diagnocons.partidas.app.models.repository.ActividadSocioRepository;
import com.diagnocons.partidas.app.models.repository.PortafolioRepository;
import com.diagnocons.partidas.app.models.repository.ProyectoRepository;
import com.diagnocons.partidas.app.models.services.interfaces.ReporteService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReporteServiceImpl implements ReporteService{
	
	private PortafolioRepository portafolioRepository;
	private ProyectoRepository proyectoRepository;
	private ActividadRepository actividadRepository;
	private ActividadSocioRepository actividadSocioRepository;
	private ActividadMaterialRepository actividadMaterialRepository;
	
	public ReporteServiceImpl(
			PortafolioRepository portafolioRepository,
			ProyectoRepository proyectoRepository,
			ActividadRepository actividadRepository,
			ActividadSocioRepository actividadSocioRepository,
			ActividadMaterialRepository actividadMaterialRepository
	) {
		this.portafolioRepository = portafolioRepository;
		this.proyectoRepository = proyectoRepository;
		this.actividadRepository = actividadRepository;
		this.actividadSocioRepository = actividadSocioRepository;
		this.actividadMaterialRepository = actividadMaterialRepository;
	}
	
	@Override
	public Portafolio obtenerReporteDeProyectosPorPortafolio(Long portafolioId) {
		Optional<Portafolio> o = portafolioRepository.findById(portafolioId);
		
		if(o.isEmpty()) {
			throw new EntityNotFoundException("No existe el portafolio");
		}
		
		Portafolio portafolio = o.get();
		
		List<Proyecto> proyectos = proyectoRepository.encontrarPorPortafolio(portafolioId);
		
		for(int i=0; i<proyectos.size(); i++) {
			proyectos.get(i).setActividades(
				actividadRepository.buscarPorProyecto(proyectos.get(0).getId())
			); 
			
			for(int j=0; j<proyectos.get(i).getActividades().size(); j++) {
				
				List<Material> materiales = actividadMaterialRepository.;
				List<Socio> socios = null;
				
				proyectos.get(i).getActividades().get(j).setMateriales(materiales);
				proyectos.get(i).getActividades().get(j).setSocios(socios);
			}
			
		}
		
		portafolio.setProyectos(proyectos);
		
		return portafolio;
	}


}
