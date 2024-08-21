package com.bellafoundation.bella_foundation_user_service.security.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private Long id;
    private String code;
    private String name;

    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
