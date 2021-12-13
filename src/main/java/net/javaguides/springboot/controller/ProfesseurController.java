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
import net.javaguides.springboot.models.Professeur;
import net.javaguides.springboot.repository.ProfesseurRepository;

@CrossOrigin(origins="*")
@RestController 
@RequestMapping("/")
public class ProfesseurController {
	
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	//get all professeur 
	
	@GetMapping("/profs")
	public List<Professeur>getallProfesseur(){
		return professeurRepository.findAll();
	}
	
	//get Professeur By Id 
	
	@GetMapping("/prof/{id}")
	
	public ResponseEntity<Professeur> getProfesseur(@PathVariable Long id){
		Professeur professeur = professeurRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		
		return ResponseEntity.ok(professeur);
	}
	
	//create Professeur 
	
	@PostMapping("/prof")
	public Professeur createProfesseur(@RequestBody Professeur professeur) {
		
		return professeurRepository.save(professeur);
	}
	
	//update professeur 
	
	@PutMapping("/prof/{id}")
	
	public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long id,@RequestBody Professeur professeurDetails){
		Professeur professeur = professeurRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		professeur.setEmail(professeurDetails.getEmail());
		professeur.setGrade(professeurDetails.getGrade());
		professeur.setNom(professeurDetails.getNom());
		professeur.setPrenom(professeurDetails.getPrenom());
		
		Professeur updatedProfesseur=professeurRepository.save(professeur);
		
		return ResponseEntity.ok(updatedProfesseur);
	}
	
	//delete Preofesseur 
	
	@DeleteMapping("/prof/{id}")
	
	public ResponseEntity<Map<String,Boolean>> deleteProf(@PathVariable Long  id){
		Professeur professeur = professeurRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		professeurRepository.delete(professeur);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Delete",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	 @PostMapping("/login")
	    public Professeur Login(@RequestBody Professeur professeur) {
	        Professeur oldProfesseur = professeurRepository.findByEmailAndPassword(professeur.email, professeur.password);
	        
	        return oldProfesseur;
	    }

}
