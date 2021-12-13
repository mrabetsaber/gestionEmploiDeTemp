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
import net.javaguides.springboot.models.Etudiant;
import net.javaguides.springboot.repository.EtudianRepository;

@CrossOrigin(origins="")
@RestController 
@RequestMapping("/")
public class EtudianController {
	
	@Autowired
	private EtudianRepository etudiantRepository;
	
	//get all Etudiants
	
	@GetMapping("/etudiant")
	public List<Etudiant>getallEtudian(){
		return etudiantRepository.findAll();
	}
	
	//get Etudian By Id 
	
	@GetMapping("/etudiant/{id}")
	
	public ResponseEntity<Etudiant> getEtudiant(@PathVariable Long id){
		Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		
		return ResponseEntity.ok(etudiant);
	}
	
	//create Etudiant
	
	@PostMapping("/etudiant")
	public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
		
		return etudiantRepository.save(etudiant);
	}
	
	//update Etudiant 
	
	@PutMapping("/etudiant/{id}")
	
	public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id,@RequestBody Etudiant etudiantDetails){
		Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		etudiant.setEmail(etudiantDetails.getEmail());
		etudiant.setNom(etudiantDetails.getNom());
		etudiant.setPrenom(etudiantDetails.getPrenom());
		
		Etudiant updatedEtudiant=etudiantRepository.save(etudiant);
		
		return ResponseEntity.ok(updatedEtudiant);
	}
	
	//delete etudiant 
	
	@DeleteMapping("/etudiant/{id}")
	
	public ResponseEntity<Map<String,Boolean>> deleteEtudiant(@PathVariable Long  id){
		Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		etudiantRepository.delete(etudiant);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Delete",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

}
