package com.bellafoundation.bella_foundation_user_service.security.repo;

import com.bellafoundation.bella_foundation_user_service.security.entities.AppCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppCredentialRepository extends JpaRepository<AppCredentials,Long> {
    AppCredentials findFirstByAppCode(String appCode);
}
