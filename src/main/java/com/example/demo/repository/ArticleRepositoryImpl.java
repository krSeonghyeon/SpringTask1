package com.example.demo.repository;

import com.example.demo.domain.Article;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class ArticleRepositoryImpl implements ArticleRepository{

    private static final Map<Long, Article> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Article save(Article article) {
        article.setId(++sequence);
        store.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Article updateById(Long id, Article updateArticle) {
        updateArticle.setId(id);
        store.put(id, updateArticle);
        return updateArticle;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
