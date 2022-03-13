package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Localizacao.findAllByContentor",query = "SELECT l FROM Localizacao l WHERE l.contentor.id = ?1")
})
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private boolean atual;
    @Column
    private String localidade;
    @Column
    private String rua;
    @Column
    private String descricao;
    @Column
    private Double coordenadas1;
    @Column
    private Double coordenadas2;

    @ManyToOne
    @JoinColumn (name = "fk_contentor")
    private Contentor contentor;

}
