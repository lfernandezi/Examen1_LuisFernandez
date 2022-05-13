package com.idat.Evaluacion1SW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion1SW.dto.CursoDTOResponse;
import com.idat.Evaluacion1SW.dto.MallaDTORequest;
import com.idat.Evaluacion1SW.dto.MallaDTOResponse;
import com.idat.Evaluacion1SW.model.Curso;
import com.idat.Evaluacion1SW.model.MallaCurricular;
import com.idat.Evaluacion1SW.repository.MallaRepository;

@Service
public class MallaServiceImpl implements MallaService {

	@Autowired
	public MallaRepository mallarepo;

	@Override
	public void guardarMalla(MallaDTORequest malla) {

		MallaCurricular m = new MallaCurricular();

		m.setAnio(malla.getAniodto());
		// TODO Auto-generated method stub
		mallarepo.save(m);
	}

	@Override
	public void editarMalla(MallaDTORequest malla) {

		MallaCurricular m = new MallaCurricular();
		m.setIdMalla(malla.getIdMalladto());
		m.setAnio(malla.getAniodto());
		// TODO Auto-generated method stub
		mallarepo.saveAndFlush(m);
	}

	@Override
	public void eliminarMalla(Integer id) {
		// TODO Auto-generated method stub
		mallarepo.deleteById(id);
	}

	@Override
	public MallaDTOResponse obtenerMalla(Integer id) {

		MallaCurricular m = mallarepo.findById(id).orElse(null);

		MallaDTOResponse malla = new MallaDTOResponse();
		malla.setIdMalladto(m.getIdMalla());
		malla.setAniodto(malla.getAniodto());

		// TODO Auto-generated method stub
		return malla;
	}

	@Override
	public List<MallaDTOResponse> listarMalla() {
		
		List<MallaDTOResponse> lista = new ArrayList<MallaDTOResponse>();
		
		for (MallaCurricular m : mallarepo.findAll()) {

			MallaDTOResponse malla = new MallaDTOResponse();

			malla.setIdMalladto(m.getIdMalla());
			malla.setAniodto(malla.getAniodto());
			
			lista.add(malla);
			

		}
		// TODO Auto-generated method stub
		return lista;
	}

}
