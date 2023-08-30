package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {

	@Query("select a from Actividad a where a.proyecto.id = ?1")
	List<Actividad> buscarPorProyecto(Long proyectoId);
	
}
