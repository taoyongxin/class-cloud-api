package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Data
@Builder
public class UserDev {
    private Integer id;
    private String mobile;
    private String password;
}
