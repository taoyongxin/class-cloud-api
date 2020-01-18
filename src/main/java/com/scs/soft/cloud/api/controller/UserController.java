package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.service.UserService;
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
@RequestMapping(value = "/api/userMaster")
@Api(value = "UserController",tags = {"用户模块接口"})
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "账号注册将数据写入用户主表",notes = "")
    @PostMapping(value = "/register")
    Result insertUser(@RequestBody RegisterDto registerDto){
        return userService.insertUser(registerDto);
    }
}
