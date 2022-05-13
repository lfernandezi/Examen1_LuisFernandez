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


import com.idat.Evaluacion1SW.dto.MallaDTORequest;
import com.idat.Evaluacion1SW.dto.MallaDTOResponse;
import com.idat.Evaluacion1SW.services.MallaService;


@RestController
@RequestMapping("malla")
public class MallaController {
	
	@Autowired
	private MallaService mallaserv;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaDTOResponse>> listar(){
		return new ResponseEntity<List<MallaDTOResponse>>(mallaserv.listarMalla(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity <Void> guardar(@RequestBody  MallaDTORequest malla){
		mallaserv.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@RequestMapping(path="/obtenerporId/{id}", method = RequestMethod.GET)
	public ResponseEntity <MallaDTOResponse> obtenerporId(@PathVariable Integer id){
		MallaDTOResponse m = mallaserv.obtenerMalla(id);
		
		if (m!=null) {
			return new ResponseEntity<MallaDTOResponse>(m,HttpStatus.OK);
		}else {
			return new ResponseEntity<MallaDTOResponse>(m,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PATCH)
	public ResponseEntity <Void> editar(@RequestBody  MallaDTORequest malla){
		MallaDTOResponse m = mallaserv.obtenerMalla(malla.getIdMalladto());
		if (m!=null) {
			mallaserv.editarMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity <Void> eliminar(@PathVariable Integer id){
		MallaDTOResponse m = mallaserv.obtenerMalla(id);
		if (m!=null) {
			mallaserv.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
