package com.user.management.service;

import com.user.management.model.dto.Role;
import com.user.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role listAllRole(){
        Iterable<com.user.management.model.domain.Role> roles=  roleRepository.findAll();
        Iterator<com.user.management.model.domain.Role> rolesIterator=roles.iterator();
        List<String>roleList=new ArrayList<>();
        while(rolesIterator.hasNext()){
            roleList.add(rolesIterator.next().getRoleName());
        }
        Role role= new Role();
        role.setRoles(roleList);
        return role;
    }

}
