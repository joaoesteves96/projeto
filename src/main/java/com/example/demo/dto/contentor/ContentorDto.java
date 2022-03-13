package com.example.demo.dto.contentor;


import com.example.demo.model.Contentor;
import com.example.demo.model.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentorDto {

    private Integer id;

    private Integer codigo;

    private Integer capacidade;

    private String estado;

    private String tipo;


    public static ContentorDto fromModel (Contentor contentor){

        return contentor==null ? null : new ContentorDto(contentor.getId(),contentor.getCodigo(),contentor.getCapacidade(),contentor.getEstado(),
                                contentor.getTipo());

    }

}
