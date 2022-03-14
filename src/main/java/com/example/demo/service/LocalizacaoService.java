package com.example.demo.service;


import com.example.demo.dto.localizacao.LocalizacaoDto;
import com.example.demo.model.Contentor;
import com.example.demo.model.Localizacao;
import com.example.demo.repository.ContentorRepository;
import com.example.demo.repository.LocalizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class LocalizacaoService {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    LocalizacaoRepository localizacaoRepository;


    //metodo que passa o campo "atual" das localizacoes de 1 para falso a cada utilizacao
    private void setFalseLastLocation (LocalizacaoDto localizacaoDto) {

        Set<Localizacao> localizacoes = em.createNamedQuery("Localizacao.findAllByContentor",Localizacao.class)
                .setParameter(1,localizacaoDto.getContentor().getId()).getResultStream().collect(Collectors.toSet());
        for (Localizacao l : localizacoes){
            l.setAtual(false);
        }

        localizacaoRepository.saveAll(localizacoes);


    }


    public Localizacao create(LocalizacaoDto localizacaoDto, Contentor contentor){

        setFalseLastLocation(localizacaoDto);


        Localizacao localizacao = new Localizacao();

        localizacao.setRua(localizacaoDto.getRua());
        localizacao.setDescricao(localizacaoDto.getDescricao());
        localizacao.setLocalidade(localizacaoDto.getLocalidade());
        localizacao.setCoordenadas1(localizacaoDto.getCoordenadas1());
        localizacao.setCoordenadas2(localizacaoDto.getCoordenadas2());
        localizacao.setAtual(true);

        localizacao.setContentor(contentor);

        localizacaoRepository.save(localizacao);

        return localizacao;
    }

    public List<Localizacao> findAll () {
        return localizacaoRepository.findAll();
    }

    public Localizacao findById(Integer id) {
        return localizacaoRepository.getById(id);
    }

    public void deleteById(Integer id) {
        localizacaoRepository.deleteById(id);
    }

    public Localizacao updateById(Integer id, LocalizacaoDto localizacaoDto) {
        Localizacao localizacao = findById(id);
        localizacao.setLocalidade(localizacaoDto.getLocalidade());
        localizacao.setDescricao(localizacaoDto.getDescricao());
        localizacao.setCoordenadas1(localizacaoDto.getCoordenadas1());
        localizacao.setCoordenadas2(localizacaoDto.getCoordenadas2());
        localizacao.setRua(localizacaoDto.getRua());
        localizacaoRepository.save(localizacao);
        return localizacao;
    }
}
