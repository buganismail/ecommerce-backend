package com.uniyaz.eticaret.basket;

import com.uniyaz.eticaret.product.Product;
import com.uniyaz.eticaret.user.User;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basket_id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    @ForeignKey(name = "fk_basket_product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private Product product;

    @JoinColumn(name = "user_id")
    @ManyToOne
    @ForeignKey(name = "fk_basket_user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private User user;

    public Long getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(Long basket_id) {
        this.basket_id = basket_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket_id=" + basket_id +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
