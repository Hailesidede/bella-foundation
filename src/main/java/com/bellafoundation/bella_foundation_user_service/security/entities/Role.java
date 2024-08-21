package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ROLES")
@EqualsAndHashCode(callSuper=false)
public class Role extends Audit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "ID")
    private Long id;

    @JoinColumn(name = "ROLE_CATEGORY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private RoleCategory roleCategory;

    @Column(name="ROLE_NAME")
    private String roleName;

    @JoinColumn(name="STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;

    public Role(Long id){
        this.id=id;
    }
}
