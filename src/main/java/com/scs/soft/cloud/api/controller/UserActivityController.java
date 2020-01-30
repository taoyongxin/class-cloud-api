package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.UserActivity;
import com.scs.soft.cloud.api.service.UserActivityService;
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
@Api(value = "UserActivityController",tags = {"用户互动映射接口"})
@RestController
@Slf4j
@RequestMapping(value = "/api/userActivity")
public class UserActivityController {
    @Resource
    private UserActivityService userActivityService;

    @ApiOperation(value = "新增用户活动",notes = "")
    @PostMapping(value = "/insert")
    Result insertUserActivity(@RequestBody UserActivity userActivity){
        return userActivityService.insertUserActivity(userActivity);
    }
}
