package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface ActivityMapper {
    /**
     * 创建活动
     * @param activity
     * @throws SQLException
     */
     @Insert("INSERT INTO t_activity VALUES (null,#{groupId},#{userId},#{name},#{type},#{status},#{theme}," +
             "#{beginTime},#{endTime},#{joinPersonNumber},#{experience},#{thumbnail},#{use})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Activity activity) throws SQLException;
}
