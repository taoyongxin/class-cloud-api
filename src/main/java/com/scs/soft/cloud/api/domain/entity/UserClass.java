package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class UserClass {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Integer classId;
    private Integer experience;
}
