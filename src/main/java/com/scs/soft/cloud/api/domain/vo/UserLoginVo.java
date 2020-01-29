package com.scs.soft.cloud.api.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Data
@Builder
public class UserLoginVo {
    private Integer id;
    private String mobile;
    private String password;
    private String code;
    private Short status;
    private String profession;

    private String name;
    private String avatar;

}
