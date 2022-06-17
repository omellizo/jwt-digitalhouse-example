package com.digitalhouse.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhouse.jwt.model.dto.ProductDTOQueryRequest;
import com.digitalhouse.jwt.model.dto.ProductDTOQueryResponse;
import com.digitalhouse.jwt.model.dto.ProductDTORequest;
import com.digitalhouse.jwt.model.dto.ProductDTOResponse;
import com.digitalhouse.jwt.model.dto.ProductListDTOResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/product")
public class ProductController {

	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody ProductDTORequest productDTORequest) {
		log.info("Producto Creado " + productDTORequest);
		return ResponseEntity.ok(new ProductDTOResponse(("Producto Creado")));
	}
	
	@PostMapping("/query")
	public ResponseEntity<?> queryProduct(@RequestBody ProductDTOQueryRequest productDTOQueryRequest) {
		log.info("Se consultara producto " + productDTOQueryRequest);
		return ResponseEntity.ok(new ProductDTOQueryResponse(("Producto consultado con id " + productDTOQueryRequest.getId())));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listProduct() {
		log.info("Retornara la lista de productos");
		return ResponseEntity.ok(new ProductListDTOResponse("Retornara la lista de productos"));
	}
}
