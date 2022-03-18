package com.example.demo.dto.rota;


import com.example.demo.dto.contentor.ContentorDto;
import com.example.demo.model.Rota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RotaDto {


    private Integer id;

    private Integer horaInicio;

    private Integer horaFim;

    private Integer distanciaTotal;


    public static RotaDto fromModel (Rota rota){

        return rota==null ? null : new RotaDto(rota.getId(), rota.getHoraInicio(),rota.getHoraFim(), rota.getDistanciaTotal());

    }
}
