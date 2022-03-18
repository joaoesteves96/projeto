package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    //TODO: contentors ou contentores?
    //Set mesmo que List mas mais otimizado
    @OneToMany (mappedBy = "veiculo")
    private Set<Contentor> contentors;


    //TODO: one to one do veiculo
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rota_id", referencedColumnName = "id")
    private Rota rota;

}