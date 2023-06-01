package com.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "idSequence",
            sequenceName = "id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSequence")
    private Integer id;

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Instant creationDate;

    @UpdateTimestamp
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;


}
