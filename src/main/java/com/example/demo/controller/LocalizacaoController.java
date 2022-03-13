package com.example.demo.controller;


import com.example.demo.dto.localizacao.LocalizacaoDto;
import com.example.demo.model.Localizacao;
import com.example.demo.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/localizacoes")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService localizacaoService;

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PostMapping("/create")
    public LocalizacaoDto create (@RequestBody LocalizacaoDto localizacaoDto){

        Localizacao localizacao = localizacaoService.create(localizacaoDto);

        return LocalizacaoDto.fromModel(localizacao);
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping
    public List<LocalizacaoDto> findAll() {
        List<LocalizacaoDto> list = new ArrayList<>();
        for(Localizacao l: localizacaoService.findAll()) {
            list.add(LocalizacaoDto.fromModel(l));
        }
        return list;
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public LocalizacaoDto findById(@PathVariable(name = "id") Integer id) {
        Localizacao localizacao = localizacaoService.findById(id);
        return localizacao == null ? null : LocalizacaoDto.fromModel(localizacao);
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        localizacaoService.deleteById(id);
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public LocalizacaoDto update(@PathVariable(name = "id") Integer id, @RequestBody LocalizacaoDto localizacaoDto) {
        Localizacao localizacao = localizacaoService.updateById(id, localizacaoDto);
        return LocalizacaoDto.fromModel(localizacao);
    }
}
