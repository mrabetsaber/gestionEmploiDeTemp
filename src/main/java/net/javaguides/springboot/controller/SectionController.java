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
import net.javaguides.springboot.models.Section;
import net.javaguides.springboot.repository.SectionRepository;

@CrossOrigin(origins="")
@RestController
@RequestMapping("/")
public class SectionController {
	@Autowired 
	private SectionRepository sectionRepository ;
	
	//get all Sections 
	@GetMapping ("/sections")
	
	public List<Section> getallSections(){
		return sectionRepository.findAll();
	}
	
	//get section By Id
	
	@GetMapping("/section/{id}")
	public ResponseEntity<Section>getSection(@PathVariable Long id){
		Section section = sectionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		return ResponseEntity.ok(section);
	}
	
	// create section 
	@PostMapping("/section")
	public Section createSection(@RequestBody Section section) {
		return sectionRepository.save(section);
	}
	
	//update section 
	@PutMapping("/section/{id}")
	public ResponseEntity<Section> updateRepository(@PathVariable Long id, @RequestBody Section sectionDetails){
		Section section = sectionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		section.setNom(sectionDetails.getNom());
		Section updatedSection=sectionRepository.save(section);
		
		return ResponseEntity.ok(updatedSection);
	}
	
	//delete Section
	@DeleteMapping("/section/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteSection(@PathVariable Long id ){
		Section section = sectionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("section "+id+" n'existe pas"));
		sectionRepository.delete(section);
		
		Map<String,Boolean>response = new HashMap<>();
		response.put("Delete",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

}
