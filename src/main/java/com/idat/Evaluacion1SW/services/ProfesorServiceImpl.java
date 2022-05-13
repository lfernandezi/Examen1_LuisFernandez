package com.idat.Evaluacion1SW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idat.Evaluacion1SW.dto.ProfesorDTORequest;
import com.idat.Evaluacion1SW.dto.ProfesorDTOResponse;
import com.idat.Evaluacion1SW.model.Profesor;
import com.idat.Evaluacion1SW.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	public ProfesorRepository proferepo;

	@Override
	public void guardarProfesor(ProfesorDTORequest prof) {
		
		Profesor p= new Profesor();
		p.setProfesor(prof.getProfesordto());
		// TODO Auto-generated method stub
		proferepo.save(p);
	}

	@Override
	public void editarProfesor(ProfesorDTORequest prof) {
		Profesor p= new Profesor();
		p.setIdProfesor(prof.getIdProfesordto());
		p.setProfesor(prof.getProfesordto());
		
		// TODO Auto-generated method stub
		proferepo.saveAndFlush(p);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		proferepo.deleteById(id);
	}

	@Override
	public List<ProfesorDTOResponse> listarProfesor() {
		
		List<ProfesorDTOResponse> lista =new ArrayList<ProfesorDTOResponse>();
		
		for (Profesor p:proferepo.findAll()) {
			ProfesorDTOResponse prof= new ProfesorDTOResponse();
			prof.setIdProfesordto(p.getIdProfesor());
			prof.setProfesordto(p.getProfesor());
			lista.add(prof);
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesor(Integer id) {
			Profesor p = proferepo.findById(id).orElse(null);
			ProfesorDTOResponse prof= new ProfesorDTOResponse();
			
			prof.setIdProfesordto(p.getIdProfesor());
			prof.setProfesordto(p.getProfesor());
			
		
		// TODO Auto-generated method stub
		return prof;
	}

}
