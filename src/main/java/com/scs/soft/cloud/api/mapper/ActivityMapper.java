package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Activity;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
             "#{beginTime},#{endTime},#{joinPersonNumber},#{experience},#{thumbnail},#{purpose})")
     @Options(useGeneratedKeys = true,keyProperty = "id")
     void insert(Activity activity) throws SQLException;

    /**
     * 通过活动id查询活动
     * @param id
     * @return
     * @throws SQLException
     */
     @Select("SELECT * FROM t_activity WHERE id=#{id}")
     Activity getActivityById(int id) throws SQLException;

    /**
     * 修改活动信息
     * @param activity
     * @throws SQLException
     */
     @Update("UPDATE t_activity SET group_id = #{groupId} , name = #{name} , status = #{status} , begin_time = #{beginTime}" +
             ", end_time = #{endTime},purpose = #{purpose} WHERE id = #{id} ")
    void update(Activity activity) throws SQLException;

    /**
     * 通过用户id和班课id查询活动
     * @param userId
     * @param classId
     * @return
     * @throws SQLException
     */
     @Select("SELECT t1.id,t1.group_id,t1.type,t1.name as activity_name,t1.join_person_number,t1.begin_time,t1.end_time,t1.experience,t1.status,t1.style " +
             ",t2.name as group_name,t2.class_id,t2.sort_id,t2.activity_number " +
             ",t3.user_id,t3.activity_id,t3.join_time,t3.acquisition_experience,t3.join_status " +
             "FROM t_user_activity t3 " +
             "LEFT JOIN t_activity t1 " +
             "ON t3.activity_id = t1.id " +
             "LEFT JOIN t_group t2 " +
             "ON t1.group_id = t2.id " +
             "WHERE t2.class_id = #{classId} AND t3.user_id = #{userId} ")
    List<Map> getActivityByUserId(int userId , int classId) throws SQLException;

    /**
     * 删除活动
     * @param id
     * @throws SQLException
     */
     @Delete("DELETE FROM t_activity WHERE id = #{id}")
    void deleteActivity(int id) throws SQLException;

    /**
     * 通过分组id查询活动数据（一对多使用）
     * @param id
     * @param userId
     * @return
     * @throws SQLException
     */
     @Select("SELECT t1.id as activity_table_id,t1.group_id,t1.name as activity_name,t1.type,t1.status,t1.begin_time,t1.end_time,t1.join_person_number,t1.experience,t1.style," +
             "t2.user_id,t2.activity_id,t2.acquisition_experience,t2.join_status " +
             "FROM t_activity t1 " +
             "LEFT JOIN t_user_activity t2 " +
             "ON t1.id = t2.activity_id " +
             "WHERE t2.user_id = #{userId} AND t1.group_id = #{id}")
    List<Map> getActivityByGroupId(@Param("id") int id , @Param("userId") int userId) throws SQLException;

    /**
     * 修改样式style
     * @param activity
     * @throws SQLException
     */
    @Update("UPDATE t_activity SET style = #{style} WHERE id = #{id} ")
    void updateStyle(Activity activity) throws SQLException;
}
