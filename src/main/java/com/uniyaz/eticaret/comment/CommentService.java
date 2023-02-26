package com.uniyaz.eticaret.comment;

import com.uniyaz.eticaret.basket.Basket;
import com.uniyaz.eticaret.basket.BasketDao;
import com.uniyaz.eticaret.product.Product;
import com.uniyaz.eticaret.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public Comment addComment(Product product) {
        Comment comment = new Comment();
        User user = new User();

        user.setUser_id(1L);

        comment.setUser(user);
        comment.setProduct(product);

        Comment save = commentDao.save(comment);
        return save;
    }

    public List<Comment> findAllComments() {
        return commentDao.findAll();
    }

    public Comment updateComment(Product product) {
        Comment comment = new Comment();

        User user = new User();
        user.setUser_id(1L);

        comment.setProduct(product);
        comment.setUser(user);

        return commentDao.save(comment);

    }

    public void deleteComment(Long comment_id) {
        commentDao.deleteById(comment_id);
    }
}
