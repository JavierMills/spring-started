package com.springboot.rest.webservices.rest_full_web_services.user;


//hacemos una importacion de esta clase para que nos traiga todos sus metodos.

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService service;
	
	public UserController( UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		
		return service.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveAllUser(@PathVariable int id){
		
//		creamos una variable que contenga el resultado de la invocaion hacia el sevices
		
		User user = service.findOneUser(id);
//		validamos que sea null y procedemos a realizar la instancia hacia la exception 
		if(user == null) {
			throw new UserNotFoundException("id:" +id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
//		utilizamos el constructor  de enlaces de web MVC vinculado  al metodo para crear un enlace que apunta al metod del controlador.
//		
//		el metodo al que apunta es recuperar todos los usuarios y ahora que tengamos todos los enlaces
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		entityModel.add(link.withRel("all-users"));

		return entityModel;
		
		

	}  
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id){
		
//		creamos una variable que contenga el resultado de la invocaion hacia el sevices
		
		service.deleteById(id);


	}  
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	

}
