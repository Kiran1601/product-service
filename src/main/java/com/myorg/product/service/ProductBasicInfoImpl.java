package com.myorg.product.service;

import com.myorg.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.myorg.product.model.ProductBasicInfo;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductBasicInfoImpl implements IProductBasicInfo {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductBasicInfo saveProduct(ProductBasicInfo productBasicInfo) {
		return productRepository.save(productBasicInfo);
	}

	@Override
	public List<ProductBasicInfo> getAllProducts(){
		return productRepository.findAll();
	}

	@Override
	public void deleteApplication(String productId){
		if(!productRepository.existsById(productId)){
			throw new RuntimeException("Application not found");
		}
		productRepository.deleteById(productId);
	}

	@Override
	public ProductBasicInfo searchProduct(String productName) {
		return productRepository.findByProductName(productName)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Product not found with name: " + productName));
	}
}
