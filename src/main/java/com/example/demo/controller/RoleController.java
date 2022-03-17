package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//TODO: findById e update no serializer error.
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private
    RoleService roleService;

    @PostMapping("/create")
    public Role create (@RequestBody Role role){
        return roleService.create(role);
    }

    @GetMapping
    public List<Role> findAll(){
        return roleService.findAll();
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    @ResponseBody
    public Role findById(@PathVariable(name = "id") Integer id) {
        return roleService.findById(id);

    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        roleService.deleteById(id);
    }


    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public Role update(@PathVariable(name = "id") Integer id, @RequestBody Role role) {
        return roleService.updateById(id, role);
    }

}
