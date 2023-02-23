package com.uniyaz.eticaret.basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketDao extends JpaRepository<Basket, Long> {
    @Query("select basket from Basket basket " +
            "left join basket.product " +
            "left join basket.user ")
    List<Basket> findAllBasket();
}
