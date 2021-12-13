package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.models.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
	Professeur findByEmailAndPassword(String email,String password);

}
