package com.user.management.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name="authorities")
@Setter
@Getter
public class Authority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="authority")
    private String authority;

    @Column(name="authority_description")
    private String authorityDescriptions;

    @ManyToMany(mappedBy = "authorities")
    Set<Role>  role;



}
