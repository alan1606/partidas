package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.ActividadSocio;

public interface ActividadSocioRepository extends JpaRepository<ActividadSocio, Long>{

	@Query("select a from ActividadSocio a where a.actividad.id = ?1 ")
	List<ActividadSocio> encontrarPorActividadId(Long actividadId);
}
