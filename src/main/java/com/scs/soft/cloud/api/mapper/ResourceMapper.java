package com.scs.soft.cloud.api.mapper;

import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
public interface ResourceMapper {
    /**
     * 通过分组id和用户id查询该用户在此班课下分组资源的情况数据
     * @param userId
     * @param groupId
     * @return
     * @throws SQLException
     */
    @Select("SELECT t1.id,t1.name,t1.group_id,t1.experience,t1.url,t1.type,t1.create_time,t1.viewers,t1.storage_size," +
            "t2.user_id,t2.resource_id,t2.view_status " +
            "FROM t_resource t1 " +
            "LEFT JOIN t_user_resource t2 " +
            "ON t1.id = t2.resource_id " +
            "WHERE t2.user_id = #{userId} AND t1.group_id = #{groupId}")
    List<Map> getResourceByGroupId(int userId,int groupId) throws SQLException;
}
