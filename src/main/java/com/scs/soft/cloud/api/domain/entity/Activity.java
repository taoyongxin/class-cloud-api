package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Tao
 */
@Builder
@Data
public class Activity {
    private Integer id;
    private Integer groupId;
    private Integer userId;
    private String name;
    private Short type;
    private Short status;
    private String theme;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Integer joinPersonNumber;
    private Integer experience;
    private String thumbnail;
    private Short purpose;
    private Short style;
}
