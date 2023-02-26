package com.uniyaz.eticaret.comment;

import com.uniyaz.eticaret.product.Product;
import com.uniyaz.eticaret.user.User;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commnet_id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    @org.hibernate.annotations.ForeignKey(name = "fk_commit_product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private Product product;

    @JoinColumn(name = "user_id")
    @ManyToOne
    @org.hibernate.annotations.ForeignKey(name = "fk_commit_user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private User user;

    private Long prarent_id;
    private Long child_id;
    
    public Long getCommnet_id() {
        return commnet_id;
    }

    public void setCommnet_id(Long commnet_id) {
        this.commnet_id = commnet_id;
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

    public Long getPrarent_id() {
        return prarent_id;
    }

    public void setPrarent_id(Long prarent_id) {
        this.prarent_id = prarent_id;
    }

    public Long getChild_id() {
        return child_id;
    }

    public void setChild_id(Long child_id) {
        this.child_id = child_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commnet_id=" + commnet_id +
                ", product=" + product +
                ", user=" + user +
                ", prarent_id=" + prarent_id +
                ", child_id=" + child_id +
                '}';
    }
}
