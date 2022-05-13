package com.idat.Evaluacion1SW.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfesor;
	
	private String profesor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name= "curso_profesor",
			joinColumns = 
			@JoinColumn(name ="id_curso",
						nullable = false,
						unique = true,
						foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references curso(id_curso)")),
			inverseJoinColumns = 
			@JoinColumn(name ="id_profesor",
						nullable = false,
						unique = true,
						foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_profesor) references profesor(id_profesor)")))
	private List<Curso> cursos = new ArrayList<Curso>();
	

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Profesor(int idProfesor, String profesor, List<Curso> cursos) {
		super();
		this.idProfesor = idProfesor;
		this.profesor = profesor;
		this.cursos = cursos;
	}



	public int getIdProfesor() {
		return idProfesor;
	}



	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}



	public List<Curso> getCursos() {
		return cursos;
	}



	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}



	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	

}
