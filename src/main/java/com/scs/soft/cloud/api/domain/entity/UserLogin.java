package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Data
@Builder
public class UserLogin {
    private Integer id;
    private String mobile;
    private String password;
    private String code;
    private Short status;
}
