package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.models.Section;

public interface SectionRepository  extends JpaRepository<Section,Long>{

}
