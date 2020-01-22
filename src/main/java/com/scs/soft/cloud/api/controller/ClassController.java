package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
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
    Result getClassById(@PathVariable int userId) {

        return classService.getClassById(userId);
    }

    @ApiOperation(value = "通过创建者id查询该用户创建的班课信息",notes = "")
    @GetMapping(value = "/create/{creatorId}")
    Result getClassByCreatorId(@PathVariable int creatorId){
        return classService.getClassByCreatorId(creatorId);
    }
}
