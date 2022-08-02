package com.totalshakes.wstotalshakes.domain.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingrediente")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=2, message = "o nome precisa ter no mínimo dois caracteres")
    private String name;
}
