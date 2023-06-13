package com.novagroup.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novagroup.course.entities.User;

@RestController	//Para dizer q essa classe é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/users")	//Nome do recurso
public class UserResource {
	//Criar um método q vai ser um endpoint para acessar os usuários
	/* O tipo de retorno desse método é um responseEntity que é tipo específico pra retornar respostas
	 * de requisições web
	 */
	
	@GetMapping //Indica que o método responde a requisição do tipo get do http
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
