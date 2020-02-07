package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/resource")
@Api(value = "ResourceController",tags = {"资源接口"})
public class ResourceController {
    @Resource
    private ResourceService resourceService;
    @ApiOperation(value = "修改资源style",notes = "")
    @PutMapping(value = "/style")
    Result updateStyle(@RequestBody com.scs.soft.cloud.api.domain.entity.Resource resource){
        return resourceService.updateStyle(resource);
    }
}
