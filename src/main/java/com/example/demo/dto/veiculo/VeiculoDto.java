package com.example.demo.dto.veiculo;


import com.example.demo.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDto {

    private String matricula;

    private String marca;

    private String modelo;

    private String data;

    private Double carga;

    private Integer lugares;

    private String combustivel;


    public static VeiculoDto fromModel(Veiculo veiculo){

        //return igual a isto

        /*
        if(veiculo==null) {
            return null;
        }
        else {
            return new VeiculoDto(veiculo.getMatricula(),veiculo.getMarca(),veiculo.getModelo()
                                ,veiculo.getData().toString(),veiculo.getCarga(),veiculo.getLugares(),veiculo.getCombustivel());
        }

        */
        // TODO estudar isto melhor
        return veiculo==null ? null : new VeiculoDto(veiculo.getMatricula(),veiculo.getMarca(),veiculo.getModelo()
                                ,veiculo.getData().toString(),veiculo.getCarga(),veiculo.getLugares(),veiculo.getCombustivel());
    }

}
