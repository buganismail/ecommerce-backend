package com.uniyaz.eticaret.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(Product product) {
        product.setInventoryStatus(UUID.randomUUID().toString());
        return productDao.save(product);
    }

    public List<Product> findAllProducts() {

        return productDao.findAll();
    }

    public Product updateProduct(Product product) {

        return productDao.save(product);
    }

//    public Product findProductById(Long id) {
//        return productRepo.findProductById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found :( "));
//    }

    public void deleteProduct(Long product_id) {

        productDao.deleteById(product_id);
    }


}
