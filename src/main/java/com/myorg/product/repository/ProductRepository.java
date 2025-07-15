package com.myorg.product.repository;

import com.myorg.product.model.ProductBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductBasicInfo, String> {
}
