package com.demo.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@RegisterForReflection
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "article")
public class Article {
    @Id
    @SequenceGenerator(
            name = "articleSequence",
            sequenceName = "article_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articleSequence")
    private Integer id;
    @Column(name = "creationDate", nullable = false)
    private Instant createdDate;
    @Column(name = "code_article")
    private String codeArticle;
    @Column(name = "designation")
    private String designation;
    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;
    @Column(name = "tauxtva")
    private BigDecimal tauxTva;
    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;
    @Column(name = "photo")
    private String photo;
/*  @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;*/

    @Column(name = "identreprise")
    private Integer idEntreprise;
}

