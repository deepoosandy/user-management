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

    public List<Role> listAllRole() {
        Iterable<com.user.management.model.domain.Role> roles = roleRepository.findAll();
        List<Role> roleList = new ArrayList<>();
        if (roles != null) {
            Iterator<com.user.management.model.domain.Role> rolesIterator = roles.iterator();
            while (rolesIterator.hasNext()) {
                com.user.management.model.domain.Role roleEntity=rolesIterator.next();
                Role role = new Role();
                role.setId(Long.valueOf(roleEntity.getId()).intValue());
                role.setName(roleEntity.getRoleName());
                roleList.add(role);
            }
        }
        return roleList;
    }

}
