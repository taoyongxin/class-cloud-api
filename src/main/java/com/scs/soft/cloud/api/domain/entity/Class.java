package com.scs.soft.cloud.api.domain.entity;


import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class Class {
    private Integer id;
    private Integer creatorId;
    private String classType;
    private String thumbnail;
    private String name;
    private Integer invitationCode;
    private Short status;
    private Integer resourceNumber;
    private Integer activityNumber;
    private Integer messageNumber;
    private Integer memberNumber;
}