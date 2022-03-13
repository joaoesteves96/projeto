package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

}
