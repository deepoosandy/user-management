package com.user.management.service;

import com.user.management.model.domain.Role;
import com.user.management.model.dto.Authorities;
import com.user.management.model.dto.Authority;
import com.user.management.model.dto.RoleAndAuthorityMapping;
import com.user.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleAuthorityMappingService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleAndAuthorityMapping listAllRoleAuthorityMapping() {
        Iterable<com.user.management.model.domain.Role> roles = roleRepository.findAll();
        RoleAndAuthorityMapping authoritiesList = new RoleAndAuthorityMapping();
        if (roles != null) {
            Iterator<com.user.management.model.domain.Role> roleIterator = roles.iterator();
            while (roleIterator.hasNext()) {
                Authorities authorities = new Authorities();
                Role role = roleIterator.next();
                authorities.setRole(role.getRoleName());
                authorities.setRoleId(Long.valueOf(role.getId()).intValue());
                authorities.setAuthorties(role.getAuthorities1().stream().map(
                        authorityEntity -> {
                            Authority authority = new Authority();
                            authority.setAuthorityId(Long.valueOf(authorityEntity.getId()).intValue());
                            authority.setName(authorityEntity.getAuthority());
                            return authority;
                        }
                ).collect(Collectors.toList()));
                authoritiesList.add(authorities);
            }
        }
        return authoritiesList;
    }
}
