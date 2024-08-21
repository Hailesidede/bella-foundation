package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Audit implements Serializable {

    @CreatedBy
    @Column(name = "CREATED_BY")
    protected String createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="CREATED_DATE",nullable = false,updatable = false)
    private Date createdDate;

    @Transient
    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    protected String modifiedBy;

    @Transient
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "MODIFIED_ON")
    private Date modifiedOn;
}
