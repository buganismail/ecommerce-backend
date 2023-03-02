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
    private Long comment_id;

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

    private Long parent_id;
    private String text;


    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
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

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", product=" + product +
                ", user=" + user +
                ", parent_id=" + parent_id +
                ", text='" + text + '\'' +
                '}';
    }
}
