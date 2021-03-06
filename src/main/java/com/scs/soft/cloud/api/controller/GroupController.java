package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Group;
import com.scs.soft.cloud.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "查询分组数据信息（加入者）",notes = "返回用户的活动数据")
    @GetMapping(value = "/{classId}&{userId}")
    public Result getGroupMessage(@PathVariable int classId,@PathVariable int userId){
        return groupService.getGroupMessage(classId,userId);
    }

    @ApiOperation(value = "查询分组内活动数据信息",notes = "")
    @GetMapping(value = "/activity/{classId}/{userId}")
    public Result getGroup(@PathVariable int classId,@PathVariable int userId){
        return groupService.getGroup(classId,userId);
    }

    @ApiOperation(value = "查询分组内资源数据信息",notes = "")
    @GetMapping(value = "/resource/{userId}/{classId}")
    public Result getResource(@PathVariable int userId,@PathVariable int classId){
        return groupService.getResource(userId,classId);
    }

    @ApiOperation(value = "修改分组的资源活动style",notes = "")
    @PutMapping(value = "/style")
    Result updateGroupStyle(@RequestBody Group group){
        return groupService.updateGroupStyle(group);
    }
}
