package com.example.demo.dto.utilizador;

import com.example.demo.model.Fotografia;
import com.example.demo.model.Role;
import com.example.demo.model.Utilizador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String username;

    private String passwordMd5;

    private Role role;

    private Fotografia fotografia;

    //TODO: dava erro neste return, estava utilizador.getUrlFoto(), mudei para getfotografia e mudei os dados de private String urlFoto para private Fotografia fotografia
    public static UtilizadorDto fromModel (Utilizador utilizador){

        return utilizador == null ? null : new UtilizadorDto(utilizador.getId(),utilizador.getPrimeiroNome(),utilizador.getApelido()
                    ,utilizador.getDataNascimento().toString(),utilizador.getEndereco(),utilizador.getEmail(),utilizador.getNaturalidade()
                      ,utilizador.getCidade(),utilizador.getEstadoCivil(),utilizador.getNumeroSs(),utilizador.getNif()
                         ,utilizador.getTelemovel(), utilizador.getUsername(), utilizador.getPasswordMd5(), utilizador.getRole(), utilizador.getFotografia());
    }

}
