package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import com.scs.soft.cloud.api.service.UserClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping()
    Result insertUserClass(@RequestBody UserClass userClass){
        return userClassService.insertUserClass(userClass);
    }
}
