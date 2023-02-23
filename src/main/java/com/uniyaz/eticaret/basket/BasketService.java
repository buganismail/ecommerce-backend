package com.uniyaz.eticaret.basket;

import com.uniyaz.eticaret.product.Product;
import com.uniyaz.eticaret.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private final BasketDao basketDao;

    @Autowired
    public BasketService(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    public Basket addBasket(Product product) {
        Basket basket = new Basket();
        User user = new User();

        user.setUser_id(1L);

        basket.setUser(user);
        basket.setProduct(product);

        Basket save = basketDao.save(basket);
        return save;
    }

    public List<Basket> findAllBaskets() {
        return basketDao.findAll();
    }


    public Basket updateBasket(Product product) {
        Basket basket = new Basket();

        User user = new User();
        user.setUser_id(1L);

        basket.setProduct(product);
        basket.setUser(user);
        return basketDao.save(basket);
    }

    public void deleteBasket(Long basket_id) {
        basketDao.deleteById(basket_id);
    }

}
