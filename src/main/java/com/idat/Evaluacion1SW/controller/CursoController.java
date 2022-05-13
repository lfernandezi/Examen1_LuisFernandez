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

import com.idat.Evaluacion1SW.dto.CursoDTORequest;
import com.idat.Evaluacion1SW.dto.CursoDTOResponse;
import com.idat.Evaluacion1SW.services.CursoService;


//http://localhost:8080/curso/
@RestController
@RequestMapping("curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoserv;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>> listar(){
		return new ResponseEntity<List<CursoDTOResponse>>(cursoserv.listarCurso(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity <Void> guardar(@RequestBody  CursoDTORequest curso){
		cursoserv.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@RequestMapping(path="/obtenerporId/{id}", method = RequestMethod.GET)
	public ResponseEntity <CursoDTOResponse> obtenerporId(@PathVariable Integer id){
		CursoDTOResponse c =cursoserv.obtenerCurso(id);
		
		if (c!=null) {
			return new ResponseEntity<CursoDTOResponse>(c,HttpStatus.OK);
		}else {
			return new ResponseEntity<CursoDTOResponse>(c,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity <Void> editar(@RequestBody  CursoDTORequest curso){
		CursoDTOResponse c= cursoserv.obtenerCurso(curso.getIdCursodto());
		if (c!=null) {
			cursoserv.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity <Void> eliminar(@PathVariable Integer id){
		CursoDTOResponse c= cursoserv.obtenerCurso(id);
		if (c!=null) {
			cursoserv.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
}
