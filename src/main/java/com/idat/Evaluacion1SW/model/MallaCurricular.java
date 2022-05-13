package com.idat.Evaluacion1SW.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mallacurricular")
public class MallaCurricular {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMalla;
	
	private int anio;
	
	@OneToOne(mappedBy = "malla")
	private Universidad universidad;
	
	@OneToMany(mappedBy = "malla")
	private List<Curso> cursos= new ArrayList<Curso>();

	public MallaCurricular(int idMalla, int anio) {
		super();
		this.idMalla = idMalla;
		this.anio = anio;
	}

	public MallaCurricular() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(int idMalla) {
		this.idMalla = idMalla;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	

}
