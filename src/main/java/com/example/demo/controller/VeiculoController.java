package com.example.demo.controller;

import com.example.demo.dto.veiculo.VeiculoDto;
import com.example.demo.model.Localizacao;
import com.example.demo.model.Veiculo;
import com.example.demo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/veiculos")
public class VeiculoController {

    @Autowired
    private
    VeiculoService veiculoService;

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PostMapping("/create")
    public VeiculoDto create(@RequestBody VeiculoDto veiculoDto){

        Veiculo veiculo = veiculoService.create(veiculoDto);

        return VeiculoDto.fromModel(veiculo);

    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping
    public List<VeiculoDto> findAll() {
        List<VeiculoDto> list = new ArrayList<>();
        for(Veiculo v: veiculoService.findAll()) {
            list.add(VeiculoDto.fromModel(v));
        }
        return list;
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public VeiculoDto findById(@PathVariable(name = "id") Integer id) {
        Veiculo veiculo = veiculoService.findById(id);
        return veiculo == null ? null : VeiculoDto.fromModel(veiculo);
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        veiculoService.deleteById(id);
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public VeiculoDto update(@PathVariable(name = "id") Integer id, @RequestBody VeiculoDto veiculoDto) {
        Veiculo veiculo = veiculoService.updateById(id, veiculoDto);
        return VeiculoDto.fromModel(veiculo);
    }
}
