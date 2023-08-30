package com.diagnocons.partidas.app.models.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.diagnocons.partidas.app.models.entity.Portafolio;

public interface PortafolioService {
	
	public Page<Portafolio> buscarTodoPaginable(Pageable pageable);
	
	public List<Portafolio> buscarPortafoliosLikeNombre( String nombre);
	
	public Portafolio crearPortafolio( Portafolio portafolio);
	
	public void eliminarPortafolio(Long id) throws Exception;

	public Portafolio modificarPortafolio(Long id, Portafolio nuevo);

}
