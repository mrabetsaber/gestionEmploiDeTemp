package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.models.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {

}
