package com.example.demo.service;


import com.example.demo.dto.localizacao.LocalizacaoDto;
import com.example.demo.model.Localizacao;
import com.example.demo.repository.LocalizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class LocalizacaoService {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    public Localizacao create(LocalizacaoDto localizacaoDto){

        Localizacao localizacao = new Localizacao();

        localizacao.setRua(localizacaoDto.getRua());
        localizacao.setDescricao(localizacaoDto.getDescricao());
        localizacao.setLocalidade(localizacaoDto.getLocalidade());
        localizacao.setCoordenadas1(localizacaoDto.getCoordenadas1());
        localizacao.setCoordenadas2(localizacaoDto.getCoordenadas2());

        localizacaoRepository.save(localizacao);

        return localizacao;
    }

    // TODO: public Localizacao findById (Integer id)----???
}
