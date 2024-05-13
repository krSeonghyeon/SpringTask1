package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.exception.ArticleNotFoundException;
import com.example.demo.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article createArticle(Article newArticle) {
        return articleRepository.save(newArticle);
    }

    @Override
    public Article getArticleById(Long id) throws ArticleNotFoundException {
        return articleRepository.findById(id).orElseThrow(() ->
                new ArticleNotFoundException("Article not found with id: " + id));
    }

    @Override
    public Article updateArticleById(Long id, Article updateArticle) {
        return articleRepository.updateById(id, updateArticle);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }
}
