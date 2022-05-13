package com.idat.Evaluacion1SW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Evaluacion1SW.dto.UniversidadDTORequest;
import com.idat.Evaluacion1SW.dto.UniversidadDTOResponse;

import com.idat.Evaluacion1SW.services.UniversidadService;


@RestController
@RequestMapping("universidad")
public class UniversidadController {
	
	@Autowired
	private UniversidadService uniserv;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UniversidadDTOResponse>> listar(){
		return new ResponseEntity<List<UniversidadDTOResponse>>(uniserv.listarUniversidad(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity <Void> guardar(@RequestBody  UniversidadDTORequest uni){
		uniserv.guardarUniversidad(uni);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@RequestMapping(path="/obtenerporId/{id}", method = RequestMethod.GET)
	public ResponseEntity <UniversidadDTOResponse> obtenerporId(@PathVariable Integer id){
		UniversidadDTOResponse u =uniserv.obtenerUniversidad(id);
		
		if (u!=null) {
			return new ResponseEntity<UniversidadDTOResponse>(u,HttpStatus.OK);
		}else {
			return new ResponseEntity<UniversidadDTOResponse>(u,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity <Void> editar(@RequestBody  UniversidadDTORequest uni){
		UniversidadDTOResponse u= uniserv.obtenerUniversidad(uni.getIdUniversidaddto());
		if (u!=null) {
			uniserv.editarUniversidad(uni);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity <Void> eliminar(@PathVariable Integer id){
		UniversidadDTOResponse u= uniserv.obtenerUniversidad(id);
		if (u!=null) {
			uniserv.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
