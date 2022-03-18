package com.example.demo.controller;


import com.example.demo.dto.contentor.ContentorDto;
import com.example.demo.model.Contentor;
import com.example.demo.service.ContentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/contentores")
public class ContentorController {

    @Autowired
    ContentorService contentorService;

    @PostMapping("/create")
    public ContentorDto create(@RequestBody ContentorDto contentorDto){

        Contentor contentor = contentorService.create(contentorDto);

        return ContentorDto.fromModel(contentor);

    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping
    public List<ContentorDto> findAll() {
        List<ContentorDto> list = new ArrayList<>();
        for(Contentor v: contentorService.findAll()) {
            list.add(ContentorDto.fromModel(v));
        }
        return list;
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public ContentorDto findById(@PathVariable(name = "id") Integer id) {
        Contentor contentor = contentorService.findById(id);
        return contentor == null ? null : ContentorDto.fromModel(contentor);
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        contentorService.deleteById(id);
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public ContentorDto update(@PathVariable(name = "id") Integer id, @RequestBody ContentorDto contentorDto) {
        Contentor contentor = contentorService.updateById(id, contentorDto);
        return ContentorDto.fromModel(contentor);
    }
}
