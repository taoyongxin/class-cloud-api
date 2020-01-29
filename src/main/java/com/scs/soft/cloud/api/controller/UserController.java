package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;
import com.scs.soft.cloud.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 账号注册将用户信息填入主表
     * @param registerDto
     * @return
     */
    @ApiOperation(value = "账号注册将数据写入用户主表",notes = "")
    @PostMapping(value = "/register")
    Result insertUser(@RequestBody RegisterDto registerDto){
        return userService.insertUser(registerDto);
    }

    /**
     * 根据手机号码修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value = "根据手机号码修改用户的数据",notes = "")
    @PutMapping(value = "/update")
    Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ApiOperation(value = "通过手机号码查询用户信息",notes = "date为用户信息数据")
    @PostMapping(value = "/mobile")
    Result findUserByMobile(@RequestBody RegisterDto registerDto){
        return userService.findUserByMobile(registerDto);
    }
}
