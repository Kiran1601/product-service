package com.myorg.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myorg.product.model.ProductBasicInfo;
import com.myorg.product.service.IProductBasicInfo;

import java.util.List;

@RestController
public class ProductController {
	
	//creating an object of product basic info service
	@Autowired
	IProductBasicInfo iProductBasicInfo;

	@GetMapping("/welcome")
	public String greet() {
		return "Its greet method";
	}

	@PostMapping("/product")
	public ResponseEntity<ProductBasicInfo> enterProduct (@RequestBody ProductBasicInfo productBasicInfo) {
		iProductBasicInfo.saveProduct(productBasicInfo);
		return new ResponseEntity<ProductBasicInfo>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAll")
	public List<ProductBasicInfo> getAllProducts(){
		return iProductBasicInfo.getAllProducts();
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
		iProductBasicInfo.deleteApplication(productId);
		return ResponseEntity.ok("Product deleted successfully");
	}

	@GetMapping("/product/{productName}")
	public ProductBasicInfo searchProduct(@PathVariable String productName) {

		return iProductBasicInfo.searchProduct(productName);

	}

}
