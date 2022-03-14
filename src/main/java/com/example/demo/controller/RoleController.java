package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//TODO: Duvidas por nao ter Dto.
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    public Role create (@RequestBody Role role){
        return roleService.create(role);
    }

    @GetMapping
    public List<Role> findAll(){
        List<Role> list = new ArrayList<>();
        for (Role v: roleService.findAll()) {
            list.add(v);
        }
        return list;
    }


    //TODO o if no return tem de ser revisto
    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @GetMapping("/{id}")
    public Role findById(@PathVariable(name = "id") Integer id) {
        Role role1 = roleService.findById(id);
        if (role1 == null){
            return null;
        }else{
            return role1;
        }
    }

    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        roleService.deleteById(id);
    }


    //TODO shady stuff
    //METER AQUI NOME DA REQUEST do postman por exemplo POSTMAN-COLECAO XPTO: REQUEST ABCDE
    @PutMapping("/{id}")
    public Role update(@PathVariable(name = "id") Integer id, @RequestBody Role role) {
        role = roleService.updateById(id, role);
        return role;
    }

}
