package com.myorg.product.service;

import com.myorg.product.model.ProductBasicInfo;
import java.util.List;

public interface IProductBasicInfo {

	public ProductBasicInfo saveProduct(ProductBasicInfo productBasicInfo);

	List<ProductBasicInfo> getAllProducts();

	void deleteApplication(String productId);

}