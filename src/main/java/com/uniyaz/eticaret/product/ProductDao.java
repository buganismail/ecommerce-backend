package com.uniyaz.eticaret.product;

import org.springframework.data.jpa.repository.JpaRepository;

//id Long olduğu için yazdık.
public interface ProductDao extends JpaRepository<Product, Long> {
//    void deleteProduct(Long id);

//    Optional<Product> findProductById(Long id);
}
