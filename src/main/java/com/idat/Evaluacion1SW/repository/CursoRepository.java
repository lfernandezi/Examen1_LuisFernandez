package com.idat.Evaluacion1SW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Evaluacion1SW.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
