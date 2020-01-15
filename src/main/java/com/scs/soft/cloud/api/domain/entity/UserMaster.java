package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Tao
 */
@Data
@Builder
public class UserMaster {
    private String mobile;
    private String nickname;
    private String email;
    private String name;
    private String gender;
    private String avatar;
    private String school;
    private String faculty;//院系
    private Integer studentId;
    private Integer experience;//经验值
    private Integer charisma;//魅力值
    private Integer joinClass;
    private Integer createClass;
    private Integer resources;//资源总数
    private Integer activity;
    private LocalDateTime createTime;
}
