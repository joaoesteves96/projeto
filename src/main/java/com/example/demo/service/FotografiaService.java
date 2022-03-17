package com.example.demo.service;

import com.example.demo.model.Fotografia;
import com.example.demo.model.Localizacao;
import com.example.demo.model.Utilizador;
import com.example.demo.repository.ContentorRepository;
import com.example.demo.repository.FotografiaRepository;
import com.example.demo.repository.UtilizadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class FotografiaService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private FotografiaRepository fotografiaRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @Value("${diretoria.upload.imagens}")
    static String DIRETORIA_IMAGENS;

    public Fotografia upload(String fileName) {
          Fotografia fotografia = new Fotografia();
          fotografia.setUrl(DIRETORIA_IMAGENS + fileName);
          fotografiaRepository.save(fotografia);

        return em.createNamedQuery("Fotografia.findByNomeFicheiro", Fotografia.class)
                  .setParameter(1, fileName)
                  .getSingleResult();
    }

    public List<Fotografia> findAll () {
        return fotografiaRepository.findAll();
    }

    public Fotografia findById(Integer userId) {
        Utilizador utilizador = utilizadorRepository.getById(userId);
        return fotografiaRepository.getById(utilizador.getFotografia().getId());
    }

}
