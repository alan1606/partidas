package com.diagnocons.partidas.app.models.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.diagnocons.partidas.app.models.entity.Actividad;
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
			Proyecto proyecto = proyectos.get(i);
			
			List<Actividad> actividades =
					actividadRepository.buscarPorProyecto(proyecto.getId());
			
			
			for(int j=0; j<actividades.size(); j++) {
				Actividad actividad = actividades.get(j);
				List<Material> materiales = actividadMaterialRepository
						.encontrarPorActividadId(actividad.getId())
						.stream()
						.map(am -> am.getMaterial())
						.collect(Collectors.toList());
				
				List<Socio> socios = actividadSocioRepository
						.encontrarPorActividadId(actividad.getId())
						.stream()
						.map(as -> as.getSocio())
						.collect(Collectors.toList());
				
				actividad.setMateriales(materiales);
				actividad.setSocios(socios);
			}
			
			proyecto.setActividades(actividades); 

		}
		
		portafolio.setProyectos(proyectos);
		
		return portafolio;
	}


}
