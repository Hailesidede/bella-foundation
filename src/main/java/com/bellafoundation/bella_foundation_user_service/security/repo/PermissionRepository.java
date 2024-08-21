package com.bellafoundation.bella_foundation_user_service.security.repo;

import com.bellafoundation.bella_foundation_user_service.security.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    boolean existsByUrlAndStatus_Code(String url, String status);
}
