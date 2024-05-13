package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.exception.ArticleNotFoundException;

public interface ArticleService {

    public Article createArticle(Article newArticle);
    public Article getArticleById(Long id) throws ArticleNotFoundException;
    public Article updateArticleById(Long id, Article updateArticle);
    public void deleteArticleById(Long id);
}
