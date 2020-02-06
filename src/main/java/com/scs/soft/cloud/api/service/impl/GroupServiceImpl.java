package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.Group;
import com.scs.soft.cloud.api.mapper.ActivityMapper;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.mapper.GroupMapper;
import com.scs.soft.cloud.api.service.GroupService;
import com.scs.soft.cloud.api.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Tao
 */
@Service
@Slf4j
public class GroupServiceImpl implements GroupService {
    @Resource
    private CommonMapper commonMapper;
    @Resource
    private GroupMapper groupMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Override
    public Result insertGroup(Group group) {
        List<Group> groupList;
        try {
            groupList = groupMapper.getGroupByClassId(group.getClassId());
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (groupList!=null && !groupList.isEmpty()){
            StringUtil.DateComparator dateComparator = new StringUtil.DateComparator();
            Group group1 = Group.builder()
                    .name(group.getName())
                    .classId(group.getClassId())
                    .sortId(Collections.max(groupList,dateComparator).getSortId()+1)
                    .resourceNumber(0)
                    .activityNumber(0)
                    .build();
            try {
                commonMapper.alert("t_group");
                groupMapper.insert(group1);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        } else {
            Group group2 = Group.builder()
                    .name(group.getName())
                    .classId(group.getClassId())
                    .sortId(1)
                    .resourceNumber(0)
                    .activityNumber(0)
                    .build();
            try {
                commonMapper.alert("t_group");
                groupMapper.insert(group2);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        }
        return Result.success();
    }

    @Override
    public Result getGroupMessage(int classId, int userId) {
        List<Map> mapList ;
        try {
            mapList = groupMapper.getGroupMessage(classId,userId);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(mapList!=null && !mapList.isEmpty()){
            return Result.success(mapList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }

    }

    @Override
    public Result getGroup(int classId, int userId) {
        List<Map> groups;
        List<Map> map;
        try {
            groups = groupMapper.getGroup(classId);
            for (Map group:groups){
                System.out.println(group.get("name"));
                map = activityMapper.getActivityByGroupId(Integer.parseInt(group.get("id").toString()),userId);
                group.put("activityList",map);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success(groups);
    }
}
