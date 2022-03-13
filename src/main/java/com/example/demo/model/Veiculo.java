package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Veiculo.findByMatricula",query = "SELECT v FROM Veiculo v WHERE v.matricula = ?1")

})
public class Veiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String matricula;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private Date data;
    @Column
    private Double carga;
    @Column
    private Integer lugares;
    @Column
    private String combustivel;



}