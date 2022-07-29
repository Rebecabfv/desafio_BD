package com.totalshakes.wstotalshakes.domain.model;

import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.io.Serializable;
import java.util.Set;

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
    
    private String name;

    @OneToMany (mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Adicional> adicionais;
}
