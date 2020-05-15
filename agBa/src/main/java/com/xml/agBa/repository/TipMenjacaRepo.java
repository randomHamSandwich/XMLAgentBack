package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.TipMenjaca;

public interface TipMenjacaRepo  extends JpaRepository<TipMenjaca, Long>{

	Optional<TipMenjaca> findByIdTipMenjaca(String idTipMenjaca);
	Boolean existsByIdTipMenjaca(String idTipMenjaca);
}
