package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.exception.ArticleNotFoundException;
import com.example.demo.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article newArticle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createArticle(newArticle));
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        try {
            Article article = articleService.getArticleById(id);
            return ResponseEntity.ok(article);
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/me/{id}")
    public ResponseEntity<Article> updateArticleById(@PathVariable Long id, @RequestBody Article updateArticle) {
        return ResponseEntity.ok().body(articleService.updateArticleById(id, updateArticle));
    }

    @DeleteMapping("/me/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.noContent().build();
    }
}
