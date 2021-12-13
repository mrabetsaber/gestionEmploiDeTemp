package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matiere")
public class Matiere {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	
	
	public Matiere( String name, String type) {
		super();
		
		this.name = name;
		this.type = type;
	}
	
	
	
	public Matiere() {
		super();
	}




	public String getNom() {
		return name;
	}
	public void setNom(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	
	
}
