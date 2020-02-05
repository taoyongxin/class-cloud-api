package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.PageDto;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import com.scs.soft.cloud.api.service.UserClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 */
@RestController
@RequestMapping(value = "/api/userClass")
@Api(value = "UserClassController",tags = {"用户班课映射模块接口"})
public class UserClassController {
    @Resource
    private UserClassService userClassService;

    @ApiOperation(value = "用户申请加入班课",notes = "")
    @PostMapping("/into")
    Result insertUserClass(@RequestBody UserClass userClass){
        return userClassService.insertUserClass(userClass);
    }
    @ApiOperation(value = "查询班课中用户数据",notes = "")
    @GetMapping("/{classId}")
    Result getUserClassByClassId(@PathVariable int classId){
        return userClassService.selectUserClassByClassId(classId);
    }
    @ApiOperation(value = "查询班课中用户数据(分页)",notes = "")
    @PostMapping(value = "/userClass")
    public Result selectUserMessageByClassId(@RequestBody PageDto pageDto){
        return userClassService.selectUserMessageByClassId(pageDto);
    }



}
