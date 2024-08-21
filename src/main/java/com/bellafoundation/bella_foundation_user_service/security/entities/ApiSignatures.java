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
@Table(name = "API_SIGNATURES")
public class ApiSignatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "SIGN_FORMULAE")
    private String signFormulae;

    @Column(name = "URL")
    private String url;

    @JoinColumn(name = "STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;

}
