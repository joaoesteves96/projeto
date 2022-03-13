package com.example.demo.service;

import com.example.demo.dto.veiculo.VeiculoDto;
import com.example.demo.model.Veiculo;
import com.example.demo.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@RequiredArgsConstructor
@Service
public class VeiculoService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    VeiculoRepository veiculoRepository;

    public Veiculo create (VeiculoDto veiculoDto) {

        if(findByMatricula(veiculoDto.getMatricula()) == null) {


            Veiculo veiculo = new Veiculo();

            veiculo.setMatricula(veiculoDto.getMatricula());
            veiculo.setCarga(veiculoDto.getCarga());
            veiculo.setCombustivel(veiculoDto.getCombustivel());

            Date date1 = null;
            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(veiculoDto.getData());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            veiculo.setData(date1);
            veiculo.setLugares(veiculoDto.getLugares());
            veiculo.setMarca(veiculoDto.getMarca());
            veiculo.setModelo(veiculoDto.getModelo());

            veiculoRepository.save(veiculo);

            return veiculo;

        }else{
            return null;
        }

    }

    public Veiculo findByMatricula (String matricula){

        return em.createNamedQuery("Veiculo.findByMatricula", Veiculo.class)
                .setParameter(1,matricula)
                .getResultList().stream().findFirst().orElse(null);



    }




}
