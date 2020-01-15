package com.scs.soft.cloud.api.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @ClassName SignDto
 * @author Tao
 */
@Data
@Builder
public class SignDto {
    @NonNull
    private String mobile;
    private String password;
    private String sms;
}
