package com.example.demo.controller;

import com.example.demo.dto.contentor.ContentorDto;
import com.example.demo.model.Contentor;
import com.example.demo.model.Fotografia;
import com.example.demo.service.ContentorService;
import com.example.demo.service.FotografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fotografias")
public class FotografiaController {

    @Value("${diretoria.upload.imagens}")
    static String DIRETORIA_IMAGENS;

    @Autowired
    FotografiaService fotografiaService;

    @PostMapping("/upload")
    public Fotografia singleFileUpload(@RequestParam("file") MultipartFile file) {

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(DIRETORIA_IMAGENS + file.getOriginalFilename());
            Files.write(path, bytes);
            return fotografiaService.upload(path.getFileName().toString());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    public List<Fotografia> findAll() {
        return fotografiaService.findAll();
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public Fotografia findById(@PathVariable(name = "id") Integer userId) {
        return fotografiaService.findById(userId);
    }
}
