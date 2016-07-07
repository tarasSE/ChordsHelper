package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
@Component
public class User extends GenericEntity {

    @Mapping("username")
    @NotEmpty
//    @Size(min = 5, max = 16)
    @Column(unique = true)
    private String username;

    @Mapping("password")
    @NotEmpty
//    @Size(min = 8, max = 32)
    private String password;

    @Mapping("email")
    @Email
    @Column(unique = true)
    private String email;

}
