package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.MvtStk;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class MvtStkRepository implements PanacheRepository<MvtStk> {
    public MvtStk save(MvtStk mvtStk) {
        return getEntityManager().merge(mvtStk);
    }
    public long stockReelArticle(Integer idArticle) {
        return count("article.id", idArticle);
    }

    public List<MvtStk> findAllByArticleId(Integer idArticle) {
        return list("article.id", idArticle);
    }

}
