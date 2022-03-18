package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //TODO: formato date? mas sem a data formato hora
    private Integer horaInicio;

    private Integer horaFim;

    private Integer distanciaTotal;

    @OneToMany (mappedBy = "rota")
    private Set<Contentor> contentores;

    //TODO: dois mappedBy iguais da problema? confusao com este one do one do veiculo
    @OneToOne (mappedBy = "rota")
    private Veiculo veiculo;


}
