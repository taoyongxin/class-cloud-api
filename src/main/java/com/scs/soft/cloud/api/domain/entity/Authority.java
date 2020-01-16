package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class Authority {
    private Integer id;
    private Short type;
    private String fatherAuthority;
    private String name;
    private String authority;
    private String accredit;
    private String icon;
    private Short sort;
}
