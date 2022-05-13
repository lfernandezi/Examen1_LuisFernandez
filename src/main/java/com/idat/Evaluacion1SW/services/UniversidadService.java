package com.idat.Evaluacion1SW.services;

import java.util.List;

import com.idat.Evaluacion1SW.dto.UniversidadDTORequest;
import com.idat.Evaluacion1SW.dto.UniversidadDTOResponse;


public interface UniversidadService {
	
	public void guardarUniversidad(UniversidadDTORequest uni);
	
	public void editarUniversidad (UniversidadDTORequest uni);
	
	public void eliminarUniversidad(Integer id);
	
	public List<UniversidadDTOResponse> listarUniversidad();

	public UniversidadDTOResponse obtenerUniversidad(Integer id);

}
