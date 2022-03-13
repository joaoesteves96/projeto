package com.example.demo.service;

import com.example.demo.dto.localizacao.LocalizacaoDto;
import com.example.demo.dto.veiculo.VeiculoDto;
import com.example.demo.model.Localizacao;
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
import java.util.List;

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

            veiculo.setData(castStringToDate(veiculoDto.getData()));
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

    public Date castStringToDate(String dateStr) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date1;
    }


    public List<Veiculo> findAll () {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Integer id) {
        return veiculoRepository.getById(id);
    }

    public void deleteById(Integer id) {
        veiculoRepository.deleteById(id);
    }

    public Veiculo updateById(Integer id, VeiculoDto veiculoDto) {
        Veiculo veiculo = findById(id);
        veiculo.setCarga(veiculoDto.getCarga());
        veiculo.setCombustivel(veiculoDto.getCombustivel());
        veiculo.setData(castStringToDate(veiculoDto.getData()));
        veiculo.setLugares(veiculoDto.getLugares());
        veiculo.setMarca(veiculoDto.getMarca());
        veiculo.setModelo(veiculoDto.getModelo());
        veiculoRepository.save(veiculo);
        return veiculo;
    }




}
