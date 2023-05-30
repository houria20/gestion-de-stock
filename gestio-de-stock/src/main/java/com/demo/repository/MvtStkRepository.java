package com.demo.repository;

import com.demo.model.MvtStk;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class MvtStkRepository implements PanacheRepository<MvtStk> {
    long stockReelArticle(Integer idArticle) {
        return count("article.id", idArticle);
    }

    List<MvtStk> findAllByArticleId(Integer idArticle) {
        return list("article.id", idArticle);
    }

}
