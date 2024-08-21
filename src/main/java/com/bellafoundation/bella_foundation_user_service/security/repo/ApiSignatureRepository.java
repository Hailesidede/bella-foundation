package com.bellafoundation.bella_foundation_user_service.security.repo;

import com.bellafoundation.bella_foundation_user_service.security.entities.ApiSignatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSignatureRepository extends JpaRepository<ApiSignatures,Long> {
    ApiSignatures findFirstByUrlAndStatus_Code(String url, String statusCode);
}
