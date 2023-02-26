package com.uniyaz.eticaret.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
    @Query("select comment from Comment comment " +
            "left join comment.product " +
            "left join comment.user ")
    List<Comment> findAllComment();
}
