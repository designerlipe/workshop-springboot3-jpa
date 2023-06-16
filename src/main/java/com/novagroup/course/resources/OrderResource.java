package com.novagroup.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novagroup.course.entities.Order;
import com.novagroup.course.services.OrderService;

@RestController	//Para dizer q essa classe é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/orders")	//Nome do recurso
public class OrderResource {
	//Criar um método q vai ser um endpoint para acessar os usuários
	/* O tipo de retorno desse método é um responseEntity que é tipo específico pra retornar respostas
	 * de requisições web
	 */
	@Autowired
	private OrderService service;
	
	@GetMapping //Indica que o método responde a requisição do tipo get do http
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //indicar que a requisição vai aceitar o id dentro da url
	public ResponseEntity<Order> findById(@PathVariable Long id){ /* Pro Spring aceitar o id que vai vir por parâmetro pela url*/
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
