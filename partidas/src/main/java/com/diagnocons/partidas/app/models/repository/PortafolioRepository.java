package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.Portafolio;

public interface PortafolioRepository extends JpaRepository<Portafolio, Long>{

	@Query("select p from Portafolio p where upper(p.nombre) like concat('%', upper(?1) , '%')")
	List<Portafolio> buscarPorNombre(String nombre);

}
