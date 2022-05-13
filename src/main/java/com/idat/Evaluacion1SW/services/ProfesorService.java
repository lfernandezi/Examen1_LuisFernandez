package com.idat.Evaluacion1SW.services;

import java.util.List;

import com.idat.Evaluacion1SW.dto.ProfesorDTORequest;
import com.idat.Evaluacion1SW.dto.ProfesorDTOResponse;



public interface ProfesorService {
	
public void guardarProfesor(ProfesorDTORequest prof);
	
	public void editarProfesor (ProfesorDTORequest prof);
	
	public void eliminarProfesor(Integer id);
	
	public List<ProfesorDTOResponse> listarProfesor();

	public ProfesorDTOResponse obtenerProfesor(Integer id);

}
