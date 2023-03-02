package com.uniyaz.eticaret.comment;

import com.uniyaz.eticaret.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllCommnets() {
        List<Comment> comments = commentService.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Product product) {
        Comment newComment = commentService.addComment(product);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Product product) {
        Comment updateComment = commentService.updateComment(product);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{comment_id}")
    public ResponseEntity<?> deleteComment(@PathVariable("comment_id") Long comment_id) {
        commentService.deleteComment(comment_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{comment_id}")
    public Optional<Comment> findProductById(@PathVariable("comment_id")Long comment_id){
        return commentService.getProductById(comment_id);
    }

}
