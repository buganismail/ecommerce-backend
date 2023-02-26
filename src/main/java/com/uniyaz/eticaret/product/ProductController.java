package com.uniyaz.eticaret.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
//        Product product = productService.findProductById(id);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{product_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("product_id") Long product_id) {
        productService.deleteProduct(product_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{product_id}")
    public Optional<Product> findProductById(@PathVariable("product_id")Long product_id){
        return productService.getProductById(product_id);
    }





















}
