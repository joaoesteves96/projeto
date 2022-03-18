package com.example.demo.controller;

import com.example.demo.dto.rota.RotaDto;
import com.example.demo.model.Rota;
import com.example.demo.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {


    @Autowired
    RotaService rotaService;

    @PostMapping("/create")
    public RotaDto create(@RequestBody RotaDto rotaDto){

        Rota rota = rotaService.create(rotaDto);

        return RotaDto.fromModel(rota);
    }


    @GetMapping
    public List<RotaDto> findAll() {
        List<RotaDto> list = new ArrayList<>();
        for(Rota v: rotaService.findAll()) {
            list.add(RotaDto.fromModel(v));
        }
        return list;
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public RotaDto findById(@PathVariable(name = "id") Integer id) {
        Rota rota = rotaService.findById(id);
        return rota == null ? null : RotaDto.fromModel(rota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        rotaService.deleteById(id);
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public RotaDto update(@PathVariable(name = "id") Integer id, @RequestBody RotaDto rotaDto) {
        Rota rota = rotaService.updateById(id, rotaDto);
        return RotaDto.fromModel(rota);
    }
    
}
