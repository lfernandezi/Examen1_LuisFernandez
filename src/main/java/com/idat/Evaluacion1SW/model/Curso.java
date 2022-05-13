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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;
	
	private String curso;

	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_malla",
				nullable = true,
				unique = true,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallacurricular (id_malla)"))
	private MallaCurricular malla;
	

	@ManyToMany(mappedBy = "cursos" , cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
	private List<Profesor> profesores= new ArrayList<Profesor>();
	

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	
}
