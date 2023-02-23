package com.uniyaz.eticaret.basket;

import com.uniyaz.eticaret.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Basket>> getAllBaskets() {
        List<Basket> baskets = basketService.findAllBaskets();
        return new ResponseEntity<>(baskets, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Basket> addBasket(@RequestBody Product product) {
        Basket newBasket = basketService.addBasket(product);
        return new ResponseEntity<>(newBasket, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Basket> updateBasket(@RequestBody Product product) {
        Basket updateBasket = basketService.updateBasket(product);
        return new ResponseEntity<>(updateBasket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{basket_id}")
    public ResponseEntity<?> deleteBasket(@PathVariable("basket_id") Long basket_id) {
        basketService.deleteBasket(basket_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
