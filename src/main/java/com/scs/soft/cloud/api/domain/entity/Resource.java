package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Tao
 */
@Builder
@Data
public class Resource {
    private Integer id;
    private String name;
    private Integer groupId;
    private Integer experience;
    private String use;
    private String knowledgePoint;
    private String studyRequest;
    private Short releaseSetting;
    private String title;
    private String url;
    private String thumbnail;
    private Integer creatorId;
    private String type;
    private LocalDateTime createTime;
    private Integer viewers;
    private String storageSize;
    private Short style;
}
