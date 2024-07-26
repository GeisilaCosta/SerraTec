package br.com.serratec.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.DTO.ProductRecordsDTO;
import br.com.serratec.entity.Servico;
import br.com.serratec.models.ProductModel;
import br.com.serratec.repositories.ProductRepository;
import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired //busca a classe repository
	ProductRepository productRepository;
	
	//Metodo para receber recurso, fazer uma validacao inicial e salvar na base de dados
	@PostMapping("/products") //(URI)
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordsDTO productRecordsDTO ) {
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productRecordsDTO, productModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
		
		/*Linha 21 quando receber um post do cliente o metodo responde a requisicao
		 * 22 inicia o metodo 'saveProduct' com response do tipo model que retorna o 'model' criado em new e salvo na base de dados
		 * que recebe como corpo da solicitacao"requestBody" o dto validado 
		 * 23 inicia PM com var dentro do escopo 
		 * 24 faz a conversao de dto para model
		 * 25 retorna o status e no corpo o que foi salvo*/
	}
	

	@GetMapping("/products") //(URI)
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
		//lista todos os produtos salvos, o retorno 'responsi'porem o corpo tem uma lista 'model',
		//o metodo se chama getAllProducts, nao tem nenhuma entrada, tem como retorno 'response' com o status ok 
		//e o corpo vai ter a lista de todos os recursos que estao salvos na base de dados 'PR.findAll'
	}
	
	//busca por um especifico
	@GetMapping("/products/{id}") 
	public ResponseEntity<object> getOneProduct(@PathVariable(value="id") UUID id) {
	Optional<ProductModel> product0 = productRepository.findById(id);
		if (product0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
		}
			return ResponseEntity.status(HttpStatus.OK).body(product0.get());
			/* busca composta" produto e id",metodo'getOneProduct' com dois tipos de retorno por isso objeto
			*/
	}
	

}
