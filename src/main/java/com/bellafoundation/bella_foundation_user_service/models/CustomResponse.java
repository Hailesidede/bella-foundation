package com.bellafoundation.bella_foundation_user_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse <T> extends CustomStatus{
    private T data;

    public CustomResponse(CustomStatus customStatus) {
        this.status = customStatus.isStatus();
        this.message = customStatus.getMessage();
        this.code = customStatus.getCode();

        this.setLogCategory(customStatus.getLogCategory());
        this.setUniqueIdentity(customStatus.getUniqueIdentity());
    }


    public CustomResponse(CustomStatus customStatus, T obj) {
        this.status = customStatus.isStatus();
        this.message = customStatus.getMessage();
        this.code = customStatus.getCode();

        this.setLogCategory(customStatus.getLogCategory());
        this.setUniqueIdentity(customStatus.getUniqueIdentity());

        this.data = obj;
    }
}
