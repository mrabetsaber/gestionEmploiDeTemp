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
import net.javaguides.springboot.models.Matiere;
import net.javaguides.springboot.repository.MatierRepository;

@CrossOrigin(origins="")
@RestController
@RequestMapping("/")

public class MatierController {
	
	@Autowired
	private MatierRepository matierRepository;
	
	
	// Get all matieres
	@GetMapping("/matieres")
	public List<Matiere> getAllMatieres(){
		
		return matierRepository.findAll();
	}
	
	// get matier by id
	
	@GetMapping("/matiere/{id}")
	
	public ResponseEntity<Matiere> getMatier(@PathVariable Long id){
		Matiere matiere = matierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("matiers with id"+id+" not exist"));
		return ResponseEntity.ok(matiere);
	}
	
	//create matiere 
	
	@PostMapping("/materes")
	public Matiere createMatiere(@RequestBody Matiere matiere) {
		return matierRepository.save(matiere);
	}
	
	
	//update Matiere 
	@PutMapping("/matiere/{id}")
	
	public ResponseEntity<Matiere> updateMatiere(@PathVariable Long id, @RequestBody Matiere matiereDetails){
		
		Matiere matiere= matierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("matiers with id"+id+" not exist"));
		matiere.setNom(matiereDetails.getNom());
		matiere.setType(matiereDetails.getType());
		
		Matiere updatedMatier = matierRepository.save(matiere);
		
		return ResponseEntity.ok(updatedMatier);
		
		
		
	}
	
	
	//delete Matiere
	@DeleteMapping("matiere/{id}")
	
	public ResponseEntity<Map<String,Boolean>> deleteMAtiere(@PathVariable Long id){
		
		Matiere matiere =matierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("matiers with id"+id+" not exist"));
		
		matierRepository.delete(matiere);
		
		Map<String,Boolean> response = new HashMap< >();
		response.put("delete",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
	
	

}
