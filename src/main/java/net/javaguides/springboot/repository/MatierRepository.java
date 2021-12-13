package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.models.Matiere;

public interface MatierRepository extends JpaRepository<Matiere,Long> {

}
