package com.bellafoundation.bella_foundation_user_service.security.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "STATUS")
public class Status {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    public Status(String code){
        this.code = code;
    }
}
