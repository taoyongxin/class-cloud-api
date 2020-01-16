package com.scs.soft.cloud.api.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageDto {
    private Object field;
    private int currentPage;
    private int pageSize;
}
