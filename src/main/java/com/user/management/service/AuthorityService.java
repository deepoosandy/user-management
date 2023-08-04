package com.user.management.service;

import com.user.management.model.dto.Authority;
import com.user.management.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> listAllAuthorities() {
        Iterable<com.user.management.model.domain.Authority> authorities = authorityRepository.findAll();
        List<Authority> authoritiesList = new ArrayList<>();
        if (authorities != null) {
            Iterator<com.user.management.model.domain.Authority> authoritiesIterator = authorities.iterator();
            while (authoritiesIterator.hasNext()) {
                com.user.management.model.domain.Authority authorityEntity=  authoritiesIterator.next();
                Authority authority= new Authority();
                authority.setAuthorityId(Long.valueOf(authorityEntity.getId()).intValue());
                authority.setName(authorityEntity.getAuthority());
                authoritiesList.add(authority);
            }
        }
        return authoritiesList;
    }
}
