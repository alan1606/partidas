package com.diagnocons.partidas.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diagnocons.partidas.app.models.entity.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}
