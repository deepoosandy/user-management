package com.user.management.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name="roles")
@Setter
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="role_name")
    private String roleName;

    @Column(name="role_descriptions")
    private String roleDescriptions;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name="role_authority_mapping", joinColumns = @JoinColumn(name="role_id")
    , inverseJoinColumns = @JoinColumn(name="authority_id"))
     Set<Authority> authorities;


}
