package com.scs.soft.cloud.api.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Data
@Builder
public class QueryDto {
    private Integer id;
    private String equalsString;
    private String keywords;
}
