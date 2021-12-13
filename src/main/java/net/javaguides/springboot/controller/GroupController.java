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
import net.javaguides.springboot.models.Group;
import net.javaguides.springboot.repository.GroupRepository;

@CrossOrigin(origins="")
@RestController
@RequestMapping("/")
public class GroupController {
	
	@Autowired
	GroupRepository groupRepository;
	
	
	//get All Groups 
	@GetMapping("/Groups")
	public List<Group> getallGroup(){
		return groupRepository.findAll();
	}
	
	//get Group By Id
	
	@GetMapping("/Group/{id}")
	
	public ResponseEntity<Group> gatGrouById(@PathVariable Long id){
		Group group =groupRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Group with id"+id+" not exist"));
		
		return ResponseEntity.ok(group);
	}
	
	//create Group 
	
	@PostMapping("/group")
	
	public Group createGroup(@RequestBody Group group) {
		return groupRepository.save(group);
	}
	
	
	//update Group 
	@PutMapping("/group/{id}")
	
	public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group  groupDetails ){
		
		Group group =groupRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Group with id"+id+" not exist"));
		group.setNbEtudiant(groupDetails.getNbEtudiant());
		
		Group updatedGroup=groupRepository.save(group);
		return ResponseEntity.ok(updatedGroup);
	}
	
	//delete Group 
	
	@DeleteMapping("/group/{id}")
	
	public ResponseEntity<Map<String,Boolean>> daeleteGroup(@PathVariable Long id){
		Group group =groupRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Group with id"+id+" not exist"));
		groupRepository.delete(group);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Delete",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

}
