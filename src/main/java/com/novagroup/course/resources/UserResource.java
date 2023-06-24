package com.novagroup.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.novagroup.course.entities.User;
import com.novagroup.course.services.UserService;

@RestController	//Para dizer q essa classe é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/users")	//Nome do recurso
public class UserResource {
	//Criar um método q vai ser um endpoint para acessar os usuários
	/* O tipo de retorno desse método é um responseEntity que é tipo específico pra retornar respostas
	 * de requisições web
	 */
	@Autowired
	private UserService service;
	
	@GetMapping //Indica que o método responde a requisição do tipo get do http
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //indicar que a requisição vai aceitar o id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id){ /* Pro Spring aceitar o id que vai vir por parâmetro pela url*/
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
