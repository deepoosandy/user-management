package com.user.management.service;

import com.user.management.model.domain.Role;
import com.user.management.model.dto.Authorities;
import com.user.management.model.dto.Authority;
import com.user.management.model.dto.RoleAndAuthorityMapping;
import com.user.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RoleAuthorityMappingService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleAndAuthorityMapping listAllRoleAuthorityMapping() {
        Iterable<Role> roles = roleRepository.findAll();
        RoleAndAuthorityMapping authoritiesList = new RoleAndAuthorityMapping();
        if (roles != null) {
            Iterator<Role> roleIterator = roles.iterator();
            while (roleIterator.hasNext()) {
                Authorities authorities = new Authorities();
                Role role = roleIterator.next();
                authorities.setRole(role.getRoleName());
                authorities.setRoleId(Long.valueOf(role.getId()).intValue());
                authorities.setAuthorties(role.getAuthorities().stream().map(
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

    public List<Authorities> updateAuthorityMapping(List<Authorities> authorities) {
        try {
            authorities.forEach(authorities1 -> updateRoleAndAuthority(authorities1));
        } catch (Exception exception) {

        }
        return authorities;
    }

    private void updateRoleAndAuthority(Authorities authorities) {
        Optional<Role> roleEntity = roleRepository.findById(Long.valueOf(authorities.getRoleId()));
        if (roleEntity.isPresent()) {
            Role role = roleEntity.get();
            Map<Integer, com.user.management.model.domain.Authority> existingAuthoritiesForRole =
                    role.getAuthorities().stream().collect(Collectors.toMap(autEntity -> (int) (long) autEntity.getId(),
                            Function.identity()));
            Set<com.user.management.model.domain.Authority> updateAuthority = new HashSet<>();
            for (Authority authorityDto : authorities.getAuthorties()) {
                com.user.management.model.domain.Authority forUpdate = null;
                if (existingAuthoritiesForRole.containsKey(authorityDto.getAuthorityId())) {
                    forUpdate = existingAuthoritiesForRole.get(authorityDto.getAuthorityId());
                } else {
                    forUpdate = new com.user.management.model.domain.Authority();
                }
                forUpdate.setAuthority(authorityDto.getName());
                forUpdate.setId(authorityDto.getAuthorityId());
                updateAuthority.add(forUpdate);
            }
            role.setAuthorities(updateAuthority);
            Role savedRole = roleRepository.save(role);
            authorities.setRole(savedRole.getRoleName());
            authorities.setRoleId(Long.valueOf(savedRole.getId()).intValue());
            authorities.setAuthorties(savedRole.getAuthorities().stream().map(a -> {
                Authority authority = new Authority();
                authority.setName(a.getAuthority());
                authority.setAuthorityId(Long.valueOf(a.getId()).intValue());
                return authority;
            }).collect(Collectors.toList()));
        }
    }
}
