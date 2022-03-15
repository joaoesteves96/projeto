package com.example.demo.dto.empregado;

import com.example.demo.model.Utilizador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilizadorDto {

    private Integer id;

    private String primeiroNome;

    private String apelido;

    private String dataNascimento;

    private String endereco;

    private String email;

    private String naturalidade;

    private String cidade;

    private String estadoCivil;

    private Integer numeroSs;

    private Integer nif;

    private Integer telemovel;


    //TODO: ver estes possiveis dados
/*
    private Object foto;
    private Role role;
    private String username;
    private String password;
*/
    public static UtilizadorDto fromModel (Utilizador utilizador){

        return utilizador == null ? null : new UtilizadorDto(utilizador.getId(),utilizador.getPrimeiroNome(),utilizador.getApelido()
                    ,utilizador.getDataNascimento().toString(),utilizador.getEndereco(),utilizador.getEmail(),utilizador.getNaturalidade()
                      ,utilizador.getCidade(),utilizador.getEstadoCivil(),utilizador.getNumeroSs(),utilizador.getNif()
                         ,utilizador.getTelemovel());
    }

}
