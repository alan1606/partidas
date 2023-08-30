package com.diagnocons.partidas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diagnocons.partidas.app.models.entity.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long>{

	@Query("select s from Socio s where upper(s.nombre) like concat('%', upper(?1) ,'%')")
	List<Socio> buscarPorNombre(String nombre);

}
