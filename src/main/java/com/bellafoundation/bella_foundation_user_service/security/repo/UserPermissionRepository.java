package com.bellafoundation.bella_foundation_user_service.security.repo;

import com.bellafoundation.bella_foundation_user_service.security.entities.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    UserPermission findFirstByPermission_UrlAndUser_IdAndStatus_Code(String Url,Long user_Id, String status);
}
