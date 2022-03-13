package com.example.demo.service;

import com.example.demo.dto.contentor.ContentorDto;
import com.example.demo.model.Contentor;
import com.example.demo.repository.ContentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ContentorService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ContentorRepository contentorRepository;

    public Contentor create(ContentorDto contentorDto){

        Contentor contentor = new Contentor();

        contentor.setTipo(contentorDto.getTipo());
        contentor.setCapacidade(contentorDto.getCapacidade());
        contentor.setCodigo(contentorDto.getCodigo());
        contentor.setEstado(contentorDto.getEstado());

        contentorRepository.save(contentor);

        return contentor;
    }

    public List<Contentor> findAll () {
        return contentorRepository.findAll();
    }

    public Contentor findById(Integer id) {
        return contentorRepository.getById(id);
    }

    public void deleteById(Integer id) {
        contentorRepository.deleteById(id);
    }

    public Contentor updateById(Integer id, ContentorDto contentorDto) {
        Contentor contentor = findById(id);

        contentor.setTipo(contentorDto.getTipo());
        contentor.setCapacidade(contentorDto.getCapacidade());
        contentor.setCodigo(contentorDto.getCodigo());
        contentor.setEstado(contentorDto.getEstado());

        contentorRepository.save(contentor);
        return contentor;
    }

}
