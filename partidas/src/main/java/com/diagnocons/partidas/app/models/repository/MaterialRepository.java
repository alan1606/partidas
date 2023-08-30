package com.diagnocons.partidas.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diagnocons.partidas.app.models.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
