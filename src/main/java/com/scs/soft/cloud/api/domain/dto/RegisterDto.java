package com.scs.soft.cloud.api.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Builder
@Data
public class RegisterDto {
    private String mobile;
    private String profession;
    private String name;
    private String jobNumber;
}
