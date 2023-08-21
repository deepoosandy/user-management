package com.user.management.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
public class UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name ="firstName")
    private String firstName = null;

    @Column(name ="lastName")
    private String lastName = null;

    @Column(name ="userId")
    private String userId = null;

    @Column(name ="userEmailId")
    private String userEmailId = null;

    @Column(name ="userPassword")
    private String userPassword = null;

    @Column(name ="roles_id")
    private Integer roles = null;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addressList ;

}
