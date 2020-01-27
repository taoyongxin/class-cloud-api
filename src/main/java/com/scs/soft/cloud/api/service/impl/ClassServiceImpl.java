package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.Class;
import com.scs.soft.cloud.api.mapper.ClassMapper;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.service.ClassService;
import com.scs.soft.cloud.api.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
@Service
@Slf4j
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;
    @Resource
    private CommonMapper commonMapper;
    @Override
    public Result getClassByUserId(int id) {
        List<Map> mapList = null;
        try {
            mapList = classMapper.getClassByUserId(id);
        } catch (SQLException e) {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success(mapList);
    }

    @Override
    public Result getClassByCreatorId(int id) {
        List<Class> classList = null;
        try {
            classList = classMapper.getClassByCreatorId(id);
        } catch (SQLException e) {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (classList!=null && !classList.isEmpty()){
            return Result.success(classList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getClassById(int id) {
        Class class1 = null;
        try {
            class1 = classMapper.getClassById(id);
        } catch (SQLException e) {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (class1 != null){
            return Result.success(class1);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getClassByInvitationCode(int invitationCode) {
        Map<String,Object> class1 = null;
        try {
            class1 = classMapper.getClassByInvitationCode(invitationCode);
        } catch (SQLException e) {
            log.error("通过邀请码查询班课信息");
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (class1!=null){
            return Result.success(class1);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result insertClass(Class class1) {
        String code = StringUtil.getInvitationCode();
        Class class2 = Class.builder()
                .creatorId(class1.getCreatorId())
                .classType(class1.getClassType())
                .thumbnail(class1.getThumbnail())
                .name(class1.getName())
                .invitationCode(Integer.valueOf(code))
                .status((short)1)
                .resourceNumber(0)
                .activityNumber(0)
                .messageNumber(0)
                .memberNumber(0)
                .semester(class1.getSemester())
                .joinPermission((short)1)
                .school(class1.getSchool())
                .faculty(class1.getFaculty())
                .studyRequirement(class1.getStudyRequirement())
                .teachingProgress(class1.getTeachingProgress())
                .examArrangement(class1.getExamArrangement())
                .build();
        try {
            commonMapper.alert("t_class");
            classMapper.insert(class2);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success(class2);
    }

    @Override
    public Result updateClass(Class class1) {
        Class class2 = null;
        try {
            class2 = classMapper.getClassById(class1.getId());
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (class2!=null){
            class2.setClassType(class1.getClassType());
            class2.setThumbnail(class1.getThumbnail());
            class2.setName(class1.getName());
            class2.setSemester(class1.getSemester());
            class2.setJoinPermission(class1.getJoinPermission());
            class2.setSchool(class1.getSchool());
            class2.setFaculty(class1.getFaculty());
            class2.setStudyRequirement(class1.getStudyRequirement());
            class2.setTeachingProgress(class1.getTeachingProgress());
            class2.setExamArrangement(class1.getExamArrangement());
            try {
                classMapper.update(class2);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
       return Result.success();
    }


}
