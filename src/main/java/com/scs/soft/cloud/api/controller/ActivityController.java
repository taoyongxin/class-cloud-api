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


    @ApiOperation(value = "修改活动信息",notes = "")
    @PutMapping(value = "/update")
    Result updateActivity(@RequestBody Activity activity){
        return activityService.updateActivity(activity);
    }

    @ApiOperation(value = "查询活动数据",notes = "返回用户的活动数据")
    @GetMapping(value = "/{userId}&{classId}")
    public Result selectActivity(@PathVariable int userId,@PathVariable int classId){
        return activityService.getActivityByUserId(userId,classId);
    }

    @ApiOperation(value = "删除活动",notes = "")
    @DeleteMapping(value = "/{id}&{groupId}")
    Result deleteActivity(@PathVariable int id,@PathVariable int groupId){
        return activityService.deleteActivity(id,groupId);
    }

    @ApiOperation(value = "修改活动style",notes = "")
    @PutMapping(value = "/style")
    Result updateStyle(@RequestBody Activity activity){
        return activityService.updateStyle(activity);
    }
}
