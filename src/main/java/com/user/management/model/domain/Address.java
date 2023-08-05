package com.user.management.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "addressLine1")
    private String addressLine1 = null;

    @Column(name = "addressLine2")
    private String addressLine2 = null;

    @Column(name = "city")
    private String city = null;

    @Column(name = "state")
    private String state = null;

    @Column(name = "country")
    private String country = null;

    @Column(name = "pincode")
    private String pincode = null;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserDetails user;

}
