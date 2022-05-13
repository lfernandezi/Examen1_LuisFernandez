package com.idat.Evaluacion1SW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion1SW.dto.CursoDTOResponse;
import com.idat.Evaluacion1SW.dto.UniversidadDTORequest;
import com.idat.Evaluacion1SW.dto.UniversidadDTOResponse;
import com.idat.Evaluacion1SW.model.Curso;
import com.idat.Evaluacion1SW.model.Universidad;
import com.idat.Evaluacion1SW.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	public UniversidadRepository unirepo;

	@Override
	public void guardarUniversidad(UniversidadDTORequest uni) {

		Universidad u = new Universidad();

		u.setUniversidad(uni.getUniversidaddto());
		;

		// TODO Auto-generated method stub
		unirepo.save(u);
	}

	@Override
	public void editarUniversidad(UniversidadDTORequest uni) {

		Universidad u = new Universidad();
		u.setIdUniversidad(uni.getIdUniversidaddto());
		u.setUniversidad(uni.getUniversidaddto());
		;

		// TODO Auto-generated method stub
		unirepo.saveAndFlush(u);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		// TODO Auto-generated method stub
		unirepo.deleteById(id);
	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidad() {

		List<UniversidadDTOResponse> lista = new ArrayList<UniversidadDTOResponse>();

		for (Universidad u : unirepo.findAll()) {
			UniversidadDTOResponse uni = new UniversidadDTOResponse();
			uni.setIdUniversidaddto(u.getIdUniversidad());
			uni.setUniversidaddto(u.getUniversidad());

			lista.add(uni);

		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidad(Integer id) {
		// TODO Auto-generated method stub
		Universidad u = unirepo.findById(id).orElse(null);
		UniversidadDTOResponse uni = new UniversidadDTOResponse();

		uni.setIdUniversidaddto(u.getIdUniversidad());
		uni.setUniversidaddto(u.getUniversidad());
		return uni;
	}

}
