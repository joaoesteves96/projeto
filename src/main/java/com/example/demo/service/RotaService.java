package com.example.demo.service;

import com.example.demo.dto.rota.RotaDto;
import com.example.demo.model.Rota;
import com.example.demo.repository.RotaRepository;
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
public class RotaService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RotaRepository rotaRepository;


    public Rota create(RotaDto rotaDto){
        Rota rota = new Rota();

        rota.setHoraInicio(rotaDto.getHoraInicio());
        rota.setHoraFim(rotaDto.getHoraFim());
        rota.setDistanciaTotal(rotaDto.getDistanciaTotal());

        rotaRepository.save(rota);

        return rota;
    }

    public List<Rota> findAll () {
        return rotaRepository.findAll();
    }

    public Rota findById(Integer id) {
        return rotaRepository.getById(id);
    }

    public void deleteById(Integer id) {
        rotaRepository.deleteById(id);
    }

    public Rota updateById(Integer id, RotaDto rotaDto) {
        Rota rota = findById(id);

        rota.setHoraInicio(rotaDto.getHoraInicio());
        rota.setHoraFim(rotaDto.getHoraFim());
        rota.setDistanciaTotal(rotaDto.getDistanciaTotal());

        rotaRepository.save(rota);
        return rota;
    }
}
