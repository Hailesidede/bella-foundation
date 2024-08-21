package com.bellafoundation.bella_foundation_user_service.security.models;

import com.bellafoundation.bella_foundation_user_service.security.entities.Permission;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialModel {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private Date lastLogin;
    private Item role;
    private Item roleCategory;
    private Item userType;
    private boolean blocked;
    private Date dateBlocked;
    private UserModel user;
    private List<Permission> permissions= new ArrayList<>();
}
