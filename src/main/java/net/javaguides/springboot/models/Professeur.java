package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
public class Professeur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String grade ;
	
	@Column
	public String email;
	@Column
	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", grade=" + grade + ", email=" + email
				+ ", password=" + password + "]";
	}

	public Professeur(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Professeur( String nom, String prenom, String grade, String email) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Professeur() {
		super();
	}
	
	
	
	
	

}
