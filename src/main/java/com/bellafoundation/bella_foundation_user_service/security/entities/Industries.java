package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INDUSTRIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Industries extends Audit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @Size(max = 100)
    private String name;

    @Column(name = "CODE")
    @Size(max = 20)
    private String code;

    @Column(name = "DESCRIPTION")
    @Size(max =200)
    private String description;

    @JoinColumn(name = "STATUS_CODE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;

    @Column(name = "VERIFIED_BY")
    private String verifiedBy;
    @Column(name = "VERIFIED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verifiedOn;
}
