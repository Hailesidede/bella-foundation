package com.bellafoundation.bella_foundation_user_service.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "APP_CREDENTIALS")
public class AppCredentials extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name="CONSUMER_KEY")
    private String consumerKey;

    @Column(name = "CONSUMER_SECRETE")
    private String consumerSecrete;

    @Column(name = "SECRETE_KEY")
    private String secreteKey;

    @Column(name = "APP_CODE")
    private String appCode;

    @Column(name = "APP_NAME")
    private String appName;

    @JoinColumn(name = "STATUS_CODDE", referencedColumnName = "CODE")
    @OneToOne(optional = false)
    private Status status;

    @Column(name = "LAST_LOGIN")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;
}
