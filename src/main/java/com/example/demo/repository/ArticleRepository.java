package com.example.demo.repository;

import com.example.demo.domain.Article;

import java.util.Optional;

public interface ArticleRepository {

    public Article save(Article article);
    public Optional<Article> findById(Long id);
    public Article updateById(Long id, Article updateArticle);
    public void deleteById(Long id);
}
