package com.scs.soft.cloud.api.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Tao
 */
@Builder
@Data
public class UserActivity {
    private Integer id;
    private Integer userId;
    private Integer activityId;
    private LocalDateTime joinTime;
    private Integer acquisitionExperience;
    private Short joinStatus;
}
