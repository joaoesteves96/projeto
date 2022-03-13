package com.example.demo.controller;

import com.example.demo.dto.veiculo.VeiculoDto;
import com.example.demo.model.Veiculo;
import com.example.demo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @PostMapping("/create")
    public VeiculoDto create(@RequestBody VeiculoDto veiculoDto){

        Veiculo veiculo = veiculoService.create(veiculoDto);

        return VeiculoDto.fromModel(veiculo);

    }
}
