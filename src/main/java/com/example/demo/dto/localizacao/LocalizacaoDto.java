package com.example.demo.dto.localizacao;

import com.example.demo.model.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoDto {


    private String localidade;

    private String rua;

    private String descricao;

    private Double coordenadas1;

    private Double coordenadas2;


    public static LocalizacaoDto fromModel (Localizacao localizacao){

    return localizacao==null ? null : new LocalizacaoDto(localizacao.getRua(),localizacao.getLocalidade(),localizacao.getDescricao()
                            ,localizacao.getCoordenadas1(),localizacao.getCoordenadas2());

    }
}
