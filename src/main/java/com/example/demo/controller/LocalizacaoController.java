package com.example.demo.controller;


import com.example.demo.dto.localizacao.LocalizacaoDto;
import com.example.demo.model.Localizacao;
import com.example.demo.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/localizacoes")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService localizacaoService;

    @PostMapping("/create")
    public LocalizacaoDto create (@RequestBody LocalizacaoDto localizacaoDto){

        Localizacao localizacao = localizacaoService.create(localizacaoDto);

        return LocalizacaoDto.fromModel(localizacao);
    }
}
