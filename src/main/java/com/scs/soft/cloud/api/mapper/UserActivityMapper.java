package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.UserActivity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface UserActivityMapper {
    /**
     * 新增用户活动映射数据
     * @param userActivity
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user_activity VALUES (null,#{userId},#{activityId},#{joinTime},#{acquisitionExperience},#{joinStatus})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(UserActivity userActivity) throws SQLException;
}
