package com.idat.Evaluacion1SW.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="universidad")
public class Universidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUniversidad;
	
	private String universidad;
	
	@OneToOne
	@JoinColumn(name ="id_malla",
				nullable=false,
				unique=true,
				foreignKey =@ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallacurricular (id_malla)"))
	private MallaCurricular malla;
	
	

	public Universidad(int idUniversidad, String universidad) {
		super();
		this.idUniversidad = idUniversidad;
		this.universidad = universidad;
	}

	public int getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public Universidad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
