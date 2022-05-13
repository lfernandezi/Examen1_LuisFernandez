package com.idat.Evaluacion1SW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion1SW.dto.CursoDTORequest;
import com.idat.Evaluacion1SW.dto.CursoDTOResponse;
import com.idat.Evaluacion1SW.model.Curso;
import com.idat.Evaluacion1SW.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	public CursoRepository cursorepo;

	@Override
	public void guardarCurso(CursoDTORequest curso) {

		Curso c = new Curso();

		c.setCurso(curso.getCursodto());
		c.setDescripcion(curso.getDescripciondto());

		// TODO Auto-generated method stub
		cursorepo.save(c);

	}

	@Override
	public void editarCurso(CursoDTORequest curso) {

		Curso c = new Curso();
		c.setIdCurso(curso.getIdCursodto());
		c.setCurso(curso.getCursodto());
		c.setDescripcion(curso.getDescripciondto());
		// TODO Auto-generated method stub
		cursorepo.saveAndFlush(c);

	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		cursorepo.deleteById(id);
	}

	@Override
	public List<CursoDTOResponse> listarCurso() {
		
		List<CursoDTOResponse> lista =new ArrayList<CursoDTOResponse>();
		
		for (Curso c:cursorepo.findAll()) {
			CursoDTOResponse curso= new CursoDTOResponse();
			curso.setIdCursodto(c.getIdCurso());
			curso.setCursodto(c.getCurso());
			curso.setDescripciondto(c.getDescripcion());
			
			lista.add(curso);
			
		}
		
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCurso(Integer id) {
		// TODO Auto-generated method stub
		Curso c =cursorepo.findById(id).orElse(null);
		
		CursoDTOResponse curso= new CursoDTOResponse();
		
		curso.setIdCursodto(c.getIdCurso());
		curso.setCursodto(c.getCurso());
		curso.setDescripciondto(c.getDescripcion());
		

		return curso;
	}

}
