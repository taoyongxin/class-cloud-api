package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class Permission {
    private Integer id;
    private String name;
    private Short type;
    private String permissionCode;
    private Integer parentId;
    private String routerUrl;
    private String icon;
    private Integer authorization;
    private Short status;
    private Short sort;
}
