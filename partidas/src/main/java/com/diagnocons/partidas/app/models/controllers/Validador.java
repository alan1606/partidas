package com.diagnocons.partidas.app.models.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class Validador {
	
	public ResponseEntity<Map<String, Object>> validar(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> errores.put(err.getField(),"El campo " + err.getField() + " " +  err.getDefaultMessage()));
		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
	
}
