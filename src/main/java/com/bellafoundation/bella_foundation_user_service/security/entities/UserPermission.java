package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USER_PERMISSIONS")
public class UserPermission {

    @Id
    @Column(name="ID")
    private Long id;

    @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Permission permission;

    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User user;

    @JoinColumn(name = "STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;
}
