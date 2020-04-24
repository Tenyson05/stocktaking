package com.login.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

//    Declaring that this will be the primary key and it will be auto generated and be under the column user_id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
//  ############################################################################################################
//    user name should be longer that 5 characters and not empty
    @Column(name= "user_name")
    @Length(min = 5, message = "Your user name must be atleast  5 characters long")
    @NotEmpty(message = "Please provide a user name")
    private String userName;

    @Column(name= "email")
    @Email(message = "*Please provide a valid email")
    @NotEmpty(message = "Please provie an email")
    private String email;

    @Column(name = "password")
    @Length(min = 7, message = "*Your password must have atleast 7 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
