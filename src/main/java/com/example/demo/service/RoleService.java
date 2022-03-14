package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//TODO: muitas duvidas como nao e preciso DTOs o create e o updateBy nao precisam dos sets e de criar novos objetos???
@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role create(Role role){
        Role role1 = new Role();
        role1.setDescricao(role.getDescricao());

        roleRepository.save(role1);

        return role1;
    }

    public List<Role> findAll(){return roleRepository.findAll();}

    public Role findById(Integer id){return roleRepository.getById(id);}

    public void deleteById(Integer id){ roleRepository.deleteById(id);}

    public Role updateById(Integer id, Role role){
        Role role1 = findById(id);

        role1.setDescricao(role.getDescricao());

        roleRepository.save(role1);
        return role1;

    }

}
