package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.service.UserDevService;
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
@RequestMapping(value = "/api/user")
@Api(value = "UserDevController",tags = {"用户模块接口"})
public class UserDevController {
    @Resource
    private UserDevService userDevService;

    @ApiOperation(value = "通过帐号密码登录",notes = "data为用户数据")
    @PostMapping(value = "/login")
    Result login(@RequestBody SignDto signDto){
        System.out.println(signDto);
        return userDevService.login(signDto);
    }
}
