package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

	@Query("select m from Material m where uppper(m.nombre) like concat('%', upper(?1) ,'%')")
	List<Material> buscarPorNombre(String nombre); 
	
}
