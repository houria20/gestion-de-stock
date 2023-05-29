package com.demo.service.impl;

import com.demo.dto.ArticleDto;
import com.demo.exception.EntityNotFoundException;
import com.demo.exception.ErrorCodes;
import com.demo.exception.InvalidEntityException;
import com.demo.model.Article;
import com.demo.repository.ArticleRepository;
import com.demo.service.ArticleService;
import com.demo.validator.ArticleValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Inject
    ArticleRepository articleRepository;

    @Override
    @Transactional
    public void save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        } else {
            Article a = ArticleDto.toEntity(dto);
            articleRepository.save(a);
        }
    }

    @Override
    @Transactional
    public void update(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        } else {
            Optional<Article> article = articleRepository.findByCodeArticle(dto.getCodeArticle());
            if (article.isPresent()) {
                articleRepository.save(ArticleDto.toEntity(dto));
            } else {
                log.error("Article ID is null");
            }
        }
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = Optional.ofNullable(articleRepository.findById(id.longValue()));
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
        /*return articleRepository.findById(Long.valueOf(id)).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );*/
    }


    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (codeArticle == null && codeArticle.equals("")) {
            log.error("Article CODE is null" + codeArticle);
            return null;
        }
        return articleRepository.findByCodeArticle(codeArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le CODE = " + codeArticle + " n'a été trouvé dans la BDD",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    // @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
        //articleRepository.listAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.delete(articleRepository.findById(Long.valueOf(id)));
    }
}
