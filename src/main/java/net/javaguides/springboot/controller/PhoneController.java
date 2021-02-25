package net.javaguides.springboot.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Phone;
import net.javaguides.springboot.service.PhoneService;

@RestController
public class PhoneController {

	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/phones")
	public ResponseEntity<List<Phone>> getAllPhone(){
		return ResponseEntity.ok().body(phoneService.getAllPhone());
	}
	
	@GetMapping("/phones/{id}")
	public ResponseEntity<Phone> getPhoneById(@PathVariable long id){
		return ResponseEntity.ok().body(phoneService.getPhoneById(id));
	}
	
	@PostMapping("/phones")
	public ResponseEntity<Phone> createPhone(@RequestBody Phone phone){
		return ResponseEntity.ok().body(this.phoneService.createPhone(phone));
	}
	
	@PutMapping("/phones/{id}")
	public ResponseEntity<Phone> updatePhone(@PathVariable UUID id, @RequestBody Phone phone){
		phone.setId(id);
		return ResponseEntity.ok().body(this.phoneService.updatePhone(phone));
	}

	@DeleteMapping("/phones/{id}")
	public HttpStatus deletePhone(@PathVariable long id){
		this.phoneService.deletePhone(id);
		return HttpStatus.OK;
	}
}
