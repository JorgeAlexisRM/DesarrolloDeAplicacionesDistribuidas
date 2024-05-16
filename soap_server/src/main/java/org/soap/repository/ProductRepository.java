package org.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.soap.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>{

	ProductModel findByName(String name);
}
