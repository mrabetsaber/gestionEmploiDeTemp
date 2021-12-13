package net.javaguides.springboot.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="group_etudiant")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	
	@Column
	private int nbEtudiant;
	
	@OneToMany(targetEntity=Etudiant.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ce_fk",referencedColumnName="id")
	private List<Etudiant> etudiants;

	public Group(long id, int nbEtudiant, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.nbEtudiant = nbEtudiant;
		this.etudiants = etudiants;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Group( int nbEtudiant) {
		super();
		
		this.nbEtudiant = nbEtudiant;
	}

	public Group() {
	}

	

	public int getNbEtudiant() {
		return nbEtudiant;
	}

	public void setNbEtudiant(int nbEtudiant) {
		this.nbEtudiant = nbEtudiant;
	}
	
	

}
