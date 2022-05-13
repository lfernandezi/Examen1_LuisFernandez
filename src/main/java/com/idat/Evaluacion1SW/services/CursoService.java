package com.idat.Evaluacion1SW.services;

import java.util.List;

import com.idat.Evaluacion1SW.dto.CursoDTORequest;
import com.idat.Evaluacion1SW.dto.CursoDTOResponse;


public interface CursoService {
	
	public void guardarCurso(CursoDTORequest curso);
	
	public void editarCurso (CursoDTORequest curso);
	
	public void eliminarCurso(Integer id);
	
	public List<CursoDTOResponse> listarCurso();

	public CursoDTOResponse obtenerCurso(Integer id);
}
