package com.scs.soft.cloud.api.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class ClassVo {
    private Integer id;
    private Integer creatorId;
    private String thumbnail;
    private String classType;
    private String name1;

    private String name2;
    private String avatar;


}