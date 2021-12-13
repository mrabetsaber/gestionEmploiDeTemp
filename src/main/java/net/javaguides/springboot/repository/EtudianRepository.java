package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.models.Etudiant;

public interface EtudianRepository extends JpaRepository<Etudiant,Long> {

}
