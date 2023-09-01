package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{

	@Query("select p from Proyecto p where p.portafolio.id = ?1 order by p.id")
	List<Proyecto> encontrarPorPortafolio(Long portafolioId);

}
