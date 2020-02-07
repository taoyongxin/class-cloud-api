package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class Group {
    private Integer id;
    private String name;
    private Integer classId;
    private Integer sortId;
    private Integer resourceNumber;
    private Integer activityNumber;
    private Short activityStyle;
    private Short resourceStyle;
}
