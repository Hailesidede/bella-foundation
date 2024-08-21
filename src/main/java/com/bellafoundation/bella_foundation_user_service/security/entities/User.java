package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="USERS")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;

    @JoinColumn(name="USER_TYPE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private UserType userType;

    @JoinColumn(name = "STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;

    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Role role;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @Column(name="FULL_NAME")
    private String fullName;
    @Column(name="COUNTRY")
    private String country;
}
