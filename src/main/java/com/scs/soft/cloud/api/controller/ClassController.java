package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Class;
import com.scs.soft.cloud.api.service.ClassService;
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
@RequestMapping(value = "/api/class")
@Api(value = "ClassController",tags = {"班课接口"})
public class ClassController {
    @Resource
    private ClassService classService;

    @ApiOperation(value = "通过用户id查询用户加入的所有班课信息",notes = "")
    @GetMapping(value = "/all/{userId}")
    Result getClassByUserId(@PathVariable int userId) {

        return classService.getClassByUserId(userId);
    }

    @ApiOperation(value = "通过班课id查询班课信息",notes = "data为班课信息数据")
    @GetMapping(value = "/{id}")
    Result getClassById(@PathVariable int id){
        return classService.getClassById(id);
    }

    @ApiOperation(value = "通过创建者id查询该用户创建的班课信息",notes = "")
    @GetMapping(value = "/create/{creatorId}")
    Result getClassByCreatorId(@PathVariable int creatorId){
        return classService.getClassByCreatorId(creatorId);
    }
    @ApiOperation(value = "通过邀请码查询班课信息",notes = "")
    @GetMapping(value = "/invitation/{invitationCode}")
    Result getClassByInvitationCode(@PathVariable int invitationCode){
        return classService.getClassByInvitationCode(invitationCode);
    }
    @ApiOperation(value = "创建班课",notes = "")
    @PostMapping(value = "/create")
    Result insertClass(@RequestBody Class class1){
        return classService.insertClass(class1);
    }
}
