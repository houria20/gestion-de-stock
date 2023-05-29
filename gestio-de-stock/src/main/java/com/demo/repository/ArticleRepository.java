package com.demo.repository;

import com.demo.model.Article;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ArticleRepository implements PanacheRepository<Article> {
    public void save(Article article) {
        getEntityManager().merge(article);//persist(article);
    }

    public Optional<Article> findByCodeArticle(String codeArticle) {
        return find("codeArticle", codeArticle).firstResultOptional();
    }
}
