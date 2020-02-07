package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/permission")
@Api(value = "GroupController",tags = {"权限接口"})
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @ApiOperation(value = "通过父类id查询权限",notes = "返回权限数据")
    @GetMapping(value = "/{parentId}")
    public Result getPermissionByParentId(@PathVariable int parentId){
        return permissionService.getPermissionByParentId(parentId);
    }

}

