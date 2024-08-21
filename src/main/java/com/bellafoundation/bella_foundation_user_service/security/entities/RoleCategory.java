package com.bellafoundation.bella_foundation_user_service.security.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="ROLE_CATEGORIES")
public class RoleCategory {
    @Id
    @Column(name= "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @JoinColumn(name="STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    @JsonIgnore
    private Status status;


}
