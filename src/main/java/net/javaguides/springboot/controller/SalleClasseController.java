package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exeption.ResourceNotFoundException;
import net.javaguides.springboot.models.SalleClasse;
import net.javaguides.springboot.repository.SalleClasserRepository;

@CrossOrigin(origins="")
@RestController
@RequestMapping("/")
public class SalleClasseController {

	@Autowired
	private SalleClasserRepository salleRepository;
	
	// get all salles 
	@GetMapping("/salleClasses")
	public List<SalleClasse> getAllsalleClasse(){
		return salleRepository.findAll();
	}
	
	//get salles by id 
	
	@GetMapping("salleClasse/{id}")
	public ResponseEntity<SalleClasse> getSalleClasseById(@PathVariable Long id){
		
		SalleClasse salleClasse = salleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Salle with id"+id+" not exist"));
		return ResponseEntity.ok(salleClasse);
		
	}
	
	//create Salle Classe
	
	@PostMapping("/salleClasse")
	public SalleClasse createSalleClasse(@RequestBody SalleClasse salleClasse) {
		return salleRepository.save(salleClasse);
	}
	
	// update Salle Classe 
	@PutMapping ("/salleClasse/{id}")
	
	public ResponseEntity<SalleClasse> updateSalleClasse(@PathVariable Long id, @RequestBody SalleClasse salleDetails ){
		
		SalleClasse salleClasse = salleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Salle with id"+id+" not exist"));
		salleClasse.setType(salleDetails.getType());
		SalleClasse updatedSalle = salleRepository.save(salleClasse);
		
		return ResponseEntity.ok(updatedSalle);
	}
	
	//Delete salle
	@DeleteMapping("/salleClasse/{id}")
	
	public ResponseEntity<Map<String,Boolean>> deleteSalleClasse(@PathVariable Long id){
		SalleClasse salleClasse = salleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Salle with id"+id+" not exist"));
		salleRepository.delete(salleClasse);
		
		Map<String,Boolean> response = new HashMap <>();
		response.put("Delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
}
