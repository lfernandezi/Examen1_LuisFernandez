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

import com.idat.Evaluacion1SW.dto.ProfesorDTORequest;
import com.idat.Evaluacion1SW.dto.ProfesorDTOResponse;
import com.idat.Evaluacion1SW.services.ProfesorService;


@RestController
@RequestMapping("profesor")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profeserv;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTOResponse>> listar(){
		return new ResponseEntity<List<ProfesorDTOResponse>>(profeserv.listarProfesor(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity <Void> guardar(@RequestBody  ProfesorDTORequest profe){
		profeserv.guardarProfesor(profe);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@RequestMapping(path="/obtenerporId/{id}", method = RequestMethod.GET)
	public ResponseEntity <ProfesorDTOResponse> obtenerporId(@PathVariable Integer id){
		ProfesorDTOResponse p =profeserv.obtenerProfesor(id);
		
		if (p!=null) {
			return new ResponseEntity<ProfesorDTOResponse>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<ProfesorDTOResponse>(p,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity <Void> editar(@RequestBody  ProfesorDTORequest profe){
		ProfesorDTOResponse p =profeserv.obtenerProfesor(profe.getIdProfesordto());
		if (p!=null) {
			profeserv.editarProfesor(profe);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity <Void> eliminar(@PathVariable Integer id){
		ProfesorDTOResponse p =profeserv.obtenerProfesor(id);
		if (p!=null) {
			profeserv.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
