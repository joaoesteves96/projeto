package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contentor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer codigo;
    @Column
    private Integer capacidade;
    @Column
    private String estado;
    @Column
    private String tipo;
    //Set mesmo que List mas mais otimizado
    @OneToMany (mappedBy = "contentor")
    private Set<Localizacao> localizacoes;

    @ManyToOne
    @JoinColumn (name = "fk_veiculo")
    private Contentor veiculo;

}
