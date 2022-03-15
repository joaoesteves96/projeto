package com.example.demo.controller;


import com.example.demo.dto.empregado.UtilizadorDto;
import com.example.demo.model.Utilizador;
import com.example.demo.service.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/utilizadores")
public class UtilizadorController {


    @Autowired
    private
    UtilizadorService utilizadorService;

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PostMapping("/create")
    public UtilizadorDto create(@RequestBody UtilizadorDto utilizadorDto){

        Utilizador utilizador = utilizadorService.create(utilizadorDto);

        return UtilizadorDto.fromModel(utilizador);

    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping
    public List<UtilizadorDto> findAll() {
        List<UtilizadorDto> list = new ArrayList<>();
        for(Utilizador u: utilizadorService.findAll()) {
            list.add(UtilizadorDto.fromModel(u));
        }
        return list;
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public UtilizadorDto findById(@PathVariable(name = "id") Integer id) {
        Utilizador utilizador = utilizadorService.findById(id);
        return utilizador == null ? null : UtilizadorDto.fromModel(utilizador);
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        utilizadorService.deleteById(id);
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public UtilizadorDto update(@PathVariable(name = "id") Integer id, @RequestBody UtilizadorDto utilizadorDto) {
        Utilizador utilizador = utilizadorService.updateById(id, utilizadorDto);
        return UtilizadorDto.fromModel(utilizador);
    }

}
