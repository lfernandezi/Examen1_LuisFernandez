package com.idat.Evaluacion1SW.services;

import java.util.List;

import com.idat.Evaluacion1SW.dto.MallaDTORequest;
import com.idat.Evaluacion1SW.dto.MallaDTOResponse;


public interface MallaService {
	
public void guardarMalla(MallaDTORequest malla);
	
	public void editarMalla (MallaDTORequest malla);
	
	public void eliminarMalla(Integer id);
	
	public List<MallaDTOResponse> listarMalla();

	public MallaDTOResponse obtenerMalla(Integer id);

}
