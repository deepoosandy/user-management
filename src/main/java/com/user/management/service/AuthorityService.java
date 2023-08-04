package com.user.management.service;

import com.user.management.model.dto.Authority;
import com.user.management.model.dto.Role;
import com.user.management.repository.AuthorityRepository;
import com.user.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    public List<String> listAllAuthorities(){
        Iterable<com.user.management.model.domain.Authority> authorities=  authorityRepository.findAll();
        Iterator<com.user.management.model.domain.Authority> authoritiesIterator=authorities.iterator();
        List<String> authoritiesIteratorList=new ArrayList<>();
        while(authoritiesIterator.hasNext()){
            authoritiesIteratorList.add(authoritiesIterator.next().getAuthority());
        }

        return authoritiesIteratorList;
    }
}
