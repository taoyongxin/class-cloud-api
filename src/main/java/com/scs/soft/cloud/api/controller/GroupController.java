package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Group;
import com.scs.soft.cloud.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/group")
@Api(value = "GroupController",tags = {"分组接口"})
public class GroupController {
    @Resource
    private GroupService groupService;

    @ApiOperation(value = "新增分组",notes = "")
    @PostMapping(value = "/insert")
    Result insertGroup(@RequestBody Group group){
        return groupService.insertGroup(group);
    }

}
