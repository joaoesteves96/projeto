package com.example.demo.dto.localizacao;

import com.example.demo.dto.contentor.ContentorDto;
import com.example.demo.model.Contentor;
import com.example.demo.model.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoDto {

    private Integer id;

    private String localidade;

    private String rua;

    private String descricao;

    private Double coordenadas1;

    private Double coordenadas2;

    private ContentorDto contentor;

    public static LocalizacaoDto fromModel (Localizacao localizacao){

    return localizacao==null ? null : new LocalizacaoDto(localizacao.getId(),localizacao.getRua(),localizacao.getLocalidade(),localizacao.getDescricao()
                            ,localizacao.getCoordenadas1(),localizacao.getCoordenadas2(), ContentorDto.fromModel(localizacao.getContentor()));

    }
}
