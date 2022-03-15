package com.example.demo.service;

import com.example.demo.dto.empregado.UtilizadorDto;
import com.example.demo.model.Utilizador;
import com.example.demo.repository.UtilizadorRepository;
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
public class UtilizadorService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UtilizadorRepository utilizadorRepository;



    public Utilizador create (UtilizadorDto utilizadorDto) {

        Utilizador utilizador = new Utilizador();
        
        utilizador.setPrimeiroNome(utilizadorDto.getPrimeiroNome());
        utilizador.setApelido(utilizadorDto.getApelido());
        utilizador.setDataNascimento(castStringToDate (utilizadorDto.getDataNascimento()));
        utilizador.setEndereco(utilizadorDto.getEndereco());
        utilizador.setEmail(utilizadorDto.getEmail());
        utilizador.setNaturalidade(utilizadorDto.getNaturalidade());
        utilizador.setCidade(utilizadorDto.getCidade());
        utilizador.setEstadoCivil(utilizadorDto.getEstadoCivil());
        utilizador.setNumeroSs(utilizadorDto.getNumeroSs());
        utilizador.setNif(utilizadorDto.getNif());
        utilizador.setTelemovel(utilizadorDto.getTelemovel());
        

        utilizadorRepository.save(utilizador);
        
        return utilizador;
            

    }


    //TODO: finBy NIF?? talvez
/*    public Utilizador findByMatricula (String matricula){

        return em.createNamedQuery("Utilizador.findByMatricula", Utilizador.class)
                .setParameter(1,matricula)
                .getResultList().stream().findFirst().orElse(null);
    }*/


    private Date castStringToDate(String dateStr) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date1;
    }



    public List<Utilizador> findAll () {
        return utilizadorRepository.findAll();
    }

    public Utilizador findById(Integer id) {
        return utilizadorRepository.getById(id);
    }

    public void deleteById(Integer id) {
        utilizadorRepository.deleteById(id);
    }


    public Utilizador updateById (Integer id, UtilizadorDto utilizadorDto) {

        Utilizador utilizador = findById(id);
        utilizador.setPrimeiroNome(utilizadorDto.getPrimeiroNome());
        utilizador.setApelido(utilizadorDto.getApelido());
        utilizador.setDataNascimento(castStringToDate (utilizadorDto.getDataNascimento()));
        utilizador.setEndereco(utilizadorDto.getEndereco());
        utilizador.setEmail(utilizadorDto.getEmail());
        utilizador.setNaturalidade(utilizadorDto.getNaturalidade());
        utilizador.setCidade(utilizadorDto.getCidade());
        utilizador.setEstadoCivil(utilizadorDto.getEstadoCivil());
        utilizador.setNumeroSs(utilizadorDto.getNumeroSs());
        utilizador.setNif(utilizadorDto.getNif());
        utilizador.setTelemovel(utilizadorDto.getTelemovel());


        utilizadorRepository.save(utilizador);

        return utilizador;
    }

}
