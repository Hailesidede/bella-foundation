package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="USER_TYPES")
public class UserType {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    public UserType(String code) {
        this.code = code;
    }
}
