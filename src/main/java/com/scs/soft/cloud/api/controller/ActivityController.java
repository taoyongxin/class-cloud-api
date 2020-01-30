package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Activity;
import com.scs.soft.cloud.api.service.ActivityService;
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
@RequestMapping(value = "/api/activity")
@Api(value = "ActivityController",tags = {"活动接口"})
public class ActivityController {
    @Resource
    private ActivityService activityService;

    @ApiOperation(value = "新增活动",notes = "")
    @PostMapping(value = "/insert")
    Result insertActivity(@RequestBody Activity activity){
        return activityService.insertActivity(activity);
    }
}
