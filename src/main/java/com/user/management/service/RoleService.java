package com.user.management.service;

import com.user.management.model.domain.Role;
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

    public List<com.user.management.model.dto.Role> listAllRole() {
        Iterable<Role> roles = roleRepository.findAll();
        List<com.user.management.model.dto.Role> roleList = new ArrayList<>();
        if (roles != null) {
            Iterator<Role> rolesIterator = roles.iterator();
            while (rolesIterator.hasNext()) {
                Role roleEntity=rolesIterator.next();
                com.user.management.model.dto.Role role = new com.user.management.model.dto.Role();
                role.setId(Long.valueOf(roleEntity.getId()).intValue());
                role.setName(roleEntity.getRoleName());
                roleList.add(role);
            }
        }
        return roleList;
    }

}
