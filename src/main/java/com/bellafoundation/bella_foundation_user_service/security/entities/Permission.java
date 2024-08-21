package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PERMISSIONS")
public class Permission {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name="URL")
    private String url;

    @Column(name= "HTTP_METHOD")
    private String httpMethod;

    @Column(name="DESCRIPTION")
    private String description;

    @JoinColumn(name="STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;
}
