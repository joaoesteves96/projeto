package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String primeiroNome;
    @Column
    private String apelido;
    @Column
    private Date dataNascimento;
    @Column
    private String endereco;
    @Column
    private String email;
    @Column
    private String naturalidade;
    @Column
    private String cidade;
    @Column
    private String estadoCivil;
    @Column
    private Integer numeroSs;
    @Column
    private Integer nif;
    @Column
    private Integer telemovel;
    @Column
    private String username;
    @Column
    private String passwordMd5;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fotografia_id", referencedColumnName = "id")
    private Fotografia fotografia;


}
