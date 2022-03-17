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
        @NamedQuery(name = "Fotografia.findByNomeFicheiro", query = "SELECT f FROM Fotografia f where f.url = ?1")
})
public class Fotografia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String url;

    @OneToOne(mappedBy = "fotografia")
    private Utilizador utilizador;
}
