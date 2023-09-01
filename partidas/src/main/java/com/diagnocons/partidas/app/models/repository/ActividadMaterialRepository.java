package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.ActividadMaterial;

public interface ActividadMaterialRepository extends JpaRepository<ActividadMaterial, Long>{

	@Query("select a from ActividadMaterial a where a.actividad.id = ?1 ")
	List<ActividadMaterial> encontrarPorActividadId(Long actividadId);
	
}
